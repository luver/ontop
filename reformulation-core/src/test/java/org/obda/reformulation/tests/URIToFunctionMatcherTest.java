package org.obda.reformulation.tests;


import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Before;
import org.obda.owlrefplatform.core.unfolding.URIToFunctionMatcher;
import org.obda.query.domain.Function;
import org.obda.query.domain.Predicate;
import org.obda.query.domain.PredicateFactory;
import org.obda.query.domain.Term;
import org.obda.query.domain.ValueConstant;
import org.obda.query.domain.imp.BasicPredicateFactoryImpl;
import org.obda.query.domain.imp.TermFactoryImpl;

public class URIToFunctionMatcherTest extends TestCase {

	URIToFunctionMatcher matcher;
	
	@Before
	public void setUp() throws Exception {
		TermFactoryImpl fac = TermFactoryImpl.getInstance();
		List<Term> variables = new LinkedList<Term>();
		variables.add(fac.createVariable("x"));
		variables.add(fac.createVariable("y"));
		
		PredicateFactory pfac = BasicPredicateFactoryImpl.getInstance();
		Predicate p = pfac.createPredicate(URI.create("http://www.obda.com/onto#individual"), 2);
		
		Term fterm = fac.createFunctionalTerm(p, variables);
		
		Map<String,Function> termList = new HashMap<String, Function>();
		termList.put(p.getName().toString(), (Function)fterm);
		
		matcher = new URIToFunctionMatcher(termList);	
	}
	
	public void testMatchURI() {
		TermFactoryImpl fac = TermFactoryImpl.getInstance();
		Function matchedTerm = matcher.getPossibleFunctionalTermMatch(fac.createURIConstant(URI.create("http://www.obda.com/onto#individual-mariano-rodriguez")));
		assertTrue(matchedTerm != null);
		assertTrue(matchedTerm.toString(), matchedTerm.getFunctionSymbol().toString().equals("http://www.obda.com/onto#individual"));
		assertTrue(matchedTerm.toString(), matchedTerm.getTerms().get(0) instanceof ValueConstant);
		assertTrue(matchedTerm.toString(), matchedTerm.getTerms().get(1) instanceof ValueConstant);
		assertTrue(matchedTerm.getTerms().get(0).toString(), matchedTerm.getTerms().get(0).getName().equals("mariano"));
		assertTrue(matchedTerm.getTerms().get(1).toString(), matchedTerm.getTerms().get(1).getName().equals("rodriguez"));
	}

}
