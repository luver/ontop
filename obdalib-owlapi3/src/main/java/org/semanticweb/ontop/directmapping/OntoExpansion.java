/*
 * Copyright (C) 2009-2013, Free University of Bozen Bolzano
 * This source code is available under the terms of the Affero General Public
 * License v3.
 * 
 * Please see LICENSE.txt for full license terms, including the availability of
 * proprietary exceptions.
 */
package org.semanticweb.ontop.directmapping;

import org.semanticweb.ontop.sql.DBMetadata;
import org.semanticweb.ontop.sql.DataDefinition;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class OntoExpansion {
	
	private String baseURI;
	
	public OntoExpansion(){
		this.baseURI=new String("http://example.org/");
	}
	
	public void setURI(String uri){
		this.baseURI = new String(uri);
	}

	
	public void enrichOntology(DBMetadata md, OWLOntology rootOntology) throws OWLOntologyStorageException{
		for(int i=0;i<md.getTableList().size();i++){
			OntoSchema os = new OntoSchema(md.getTableList().get(i));
			os.setBaseURI(this.baseURI);
			os.enrichOntology(rootOntology);
			
		}
	}

}