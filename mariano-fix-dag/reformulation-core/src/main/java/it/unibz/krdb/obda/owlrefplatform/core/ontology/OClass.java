package it.unibz.krdb.obda.owlrefplatform.core.ontology;

import it.unibz.krdb.obda.model.Predicate;

/***
 * A named class
 * 
 * @author Mariano Rodriguez Muro
 * 
 */
public interface OClass extends BasicClassDescription {
	public Predicate getPredicate();

}
