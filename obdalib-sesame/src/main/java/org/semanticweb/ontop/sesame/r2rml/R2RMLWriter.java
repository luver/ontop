/*
 * Copyright (C) 2009-2013, Free University of Bozen Bolzano
 * This source code is available under the terms of the Affero General Public
 * License v3.
 * 
 * Please see LICENSE.txt for full license terms, including the availability of
 * proprietary exceptions.
 */
package org.semanticweb.ontop.sesame.r2rml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openrdf.model.Graph;
import org.openrdf.model.Statement;
import org.openrdf.model.impl.GraphImpl;
import org.openrdf.rio.turtle.TurtleWriter;
import org.semanticweb.ontop.io.PrefixManager;
import org.semanticweb.ontop.model.CQIE;
import org.semanticweb.ontop.model.DataTypePredicate;
import org.semanticweb.ontop.model.Function;
import org.semanticweb.ontop.model.OBDAMappingAxiom;
import org.semanticweb.ontop.model.OBDAModel;
import org.semanticweb.ontop.model.OBDAQuery;
import org.semanticweb.ontop.model.Predicate;
import org.semanticweb.ontop.model.Term;
import org.semanticweb.ontop.model.URIConstant;
import org.semanticweb.ontop.model.URITemplatePredicate;
import org.semanticweb.ontop.model.ValueConstant;
import org.semanticweb.ontop.model.Variable;
import org.semanticweb.ontop.model.impl.BNodePredicateImpl;
import org.semanticweb.ontop.model.impl.FunctionalTermImpl;
import org.semanticweb.ontop.model.impl.OBDAVocabulary;


public class R2RMLWriter {
	
	private BufferedWriter out;
	private List<OBDAMappingAxiom> mappings;
	private URI sourceUri;
	private PrefixManager prefixmng;
	
	public R2RMLWriter(File file, OBDAModel obdamodel, URI sourceURI)
	{
		try {
			this.out = new BufferedWriter(new FileWriter(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.sourceUri = sourceURI;
		this.mappings = obdamodel.getMappings(sourceUri);
		this.prefixmng = obdamodel.getPrefixManager(); 
	}
	
	public R2RMLWriter(OBDAModel obdamodel, URI sourceURI)
	{
		this.sourceUri = sourceURI;	
		this.mappings = obdamodel.getMappings(sourceUri);
		this.prefixmng = obdamodel.getPrefixManager(); 
	}

	/**
	 * call this method if you need the RDF Graph
	 * that represents the R2RML mappings
	 * @return an RDF Graph
	 */
	public Graph getGraph() {
		OBDAMappingTransformer transformer = new OBDAMappingTransformer();
		List<Statement> statements = new ArrayList<Statement>();
		
		for (OBDAMappingAxiom axiom: this.mappings) {
			List<Statement> statements2 = transformer.getStatements(axiom,prefixmng);
			statements.addAll(statements2);
		}
		@SuppressWarnings("deprecation")
		Graph g = new GraphImpl(); 
		g.addAll(statements);
		return g;
	}
	
	/**
	 * the method to write the R2RML mappings
	 * from an rdf Graph to a file
	 * @param file the ttl file to write to
	 */
	public void write(File file)
	{
		try {
			//retrieve rdf graph to write
			Graph result = getGraph();
			//open output stream
			this.out = new BufferedWriter(new FileWriter(file));
			//set up turtle writer
			TurtleWriter writer =  new TurtleWriter(this.out);
			writer.startRDF();
			//handle namespaces
			Map<String, String> prefixes = this.prefixmng.getPrefixMap();
			for (String pref : prefixes.keySet()) {
				writer.handleNamespace(pref, prefixes.get(pref));
			}
			//write graph statements
			Iterator<Statement> stIterator = result.iterator();
			while (stIterator.hasNext()) {
				writer.handleStatement(stIterator.next());
			}
			writer.endRDF();
			//close output stream
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[])
	{
		String file = "/Users/timi/Documents/hdd/Project/Test Cases/mapping1.ttl";
		R2RMLReader reader = new R2RMLReader(file);
		
		R2RMLWriter writer = new R2RMLWriter(reader.readModel(URI.create("blah")),URI.create("blah"));
		File out = new File("/Users/timi/Documents/hdd/Project/Test Cases/mapping1out.ttl");
				//"C:/Project/Timi/Workspace/obdalib-parent/quest-rdb2rdf-compliance/src/main/resources/D004/WRr2rmlb.ttl");
		Graph g = writer.getGraph();
		Iterator<Statement> st = g.iterator();
		while (st.hasNext())
			System.out.println(st.next());
		writer.write(out);
		
	}
}