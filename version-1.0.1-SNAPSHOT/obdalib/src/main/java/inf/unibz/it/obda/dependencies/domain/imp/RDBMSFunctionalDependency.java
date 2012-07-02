package inf.unibz.it.obda.dependencies.domain.imp;

import java.util.Iterator;
import java.util.List;

import inf.unibz.it.obda.dependencies.domain.FunctionalDependencyAssertion;
import inf.unibz.it.obda.domain.SourceQuery;
import inf.unibz.it.obda.rdbmsgav.domain.RDBMSSQLQuery;
import inf.unibz.it.ucq.domain.QueryTerm;

/**
 * Class representing a functional dependency assertion for a 
 * relational data base management system.
 * 
 @author Manfred Gerstgrasser
 * 		   KRDB Research Center, Free University of Bolzano/Bozen, Italy 
 *
 *
 */

public class RDBMSFunctionalDependency extends FunctionalDependencyAssertion {

	public static final String FUNCTIONALDEPENDENCY = "RDBMSFunctionalDependency";
	
	/**
	 * The first query involved in this disjointness dependency assertion
	 */
	private RDBMSSQLQuery queryOne = null;
	/**
	 * The second query involved in this disjointness dependency assertion
	 */
	private RDBMSSQLQuery queryTwo = null;
	/**
	 * A list of terms associated to the first query involved in this disjointness dependency assertion
	 */
	private List<QueryTerm> termsOfQueryOne = null;
	/**
	 * A list of terms associated to the second query involved in this disjointness dependency assertion
	 */
	private List<QueryTerm> termsOfQueryTwo = null;
	/**
	 * The mapping id from which the first query comes from
	 */
	private String mappingOneId = null;
	/**
	 * The mapping id from which the second query comes from
	 */
	private String mappingTwoId = null;
	/**
	 * The data source to which the assertions is associated
	 */
	private String datasourceUri = null;
	
	/**
	 * Returns a new RDBMSFunctionalDependency object
	 * 
	 * @param uri 	the data source URI
	 * @param id1	id of first mapping
	 * @param id2	id of second mapping
	 * @param q1	the first query
	 * @param q2	the second query
	 * @param terms1	list of terms associated to the first query
	 * @param terms2	list of terms associated to the second query
	 */
	public RDBMSFunctionalDependency(String uri,String id1, String id2,RDBMSSQLQuery q1, RDBMSSQLQuery q2,
			List<QueryTerm> terms1, List<QueryTerm> terms2){
		
		datasourceUri = uri;
		queryOne = q1;
		queryTwo = q2;
		termsOfQueryOne = terms1;
		termsOfQueryTwo = terms2;
		mappingOneId = id1;
		mappingTwoId = id2;
	}
	
	
	/**
	 * Returns the first query involved in the assertion
	 */
	@Override
	public SourceQuery getSourceQueryOne() {
		return queryOne;
	}
	/**
	 * Returns the second query involved in the assertion
	 */
	@Override
	public SourceQuery getSourceQueryTwo() {
		return queryTwo;
	}
	/**
	 * Returns a list of terms associated to the first query involved in the assertion
	 */
	@Override
	public List<QueryTerm> getTermsOfQueryOne() {
		return termsOfQueryOne;
	}
	/**
	 * Returns a list of terms associated to the second query involved in the assertion
	 */
	@Override
	public List<QueryTerm> getTermsOfQueryTwo() {
		return termsOfQueryTwo;
	}
	
	@Override
	public int hashCode(){
		
		String s = queryOne.toString() + queryTwo.toString();
		Iterator<QueryTerm> it1 = termsOfQueryOne.iterator();
		Iterator<QueryTerm> it2 = termsOfQueryTwo.iterator();
		int code = s.hashCode();
		int c = 1;
		while(it1.hasNext() ){
			int aux1 = (int) Math.pow(it1.next().hashCode(), c);
			code = code + aux1;
			c++;
		}
		while(it2.hasNext()){
			int aux2 = (int) Math.pow(it2.next().hashCode(), c);
			code = code +aux2;
			c++;
		}
		return code;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof RDBMSFunctionalDependency){
			return o.toString().equals(this.toString());
		}else {
			return false;
		}
	}
	
	@Override
	public String toString(){
		
		String output = "functionOf(";
		String parameter1 = "Body."+mappingOneId + "[";
		Iterator<QueryTerm> it1 = termsOfQueryOne.iterator();
		String aux = "";
		while(it1.hasNext()){
			if(aux.length() >0){
				aux = aux + ",";
			}
			aux = aux + it1.next();
		}
		parameter1 = parameter1 +aux +"],";
		String parameter2 = "Body." + mappingTwoId +"[";
		Iterator<QueryTerm> it2 = termsOfQueryTwo.iterator();
		String aux2="";
		while(it2.hasNext()){
			if(aux2.length() >0){
				aux2 = aux2 + ",";
			}
			aux2 = aux2 + it2.next();
		}
		parameter2 =  parameter2 + aux2 + "]";
		output = output + parameter1 + parameter2 +")";
		return output;
	}

	/**
	 * Returns the associated data source URI
	 * @return URI as String object
	 */
	public String getDatasourceUri() {
		return datasourceUri;
	}


	public String getMappingOneId() {
		return mappingOneId;
	}


	public String getMappingTwoId() {
		return mappingTwoId;
	}
	
	
}