/*
 * Copyright (C) 2009-2013, Free University of Bozen Bolzano
 * This source code is available under the terms of the Affero General Public
 * License v3.
 * 
 * Please see LICENSE.txt for full license terms, including the availability of
 * proprietary exceptions.
 */
package it.unibz.krdb.obda.quest.datatypes;

import junit.framework.Test;

public class PgsqlDatatypeTest extends QuestDatatypeParent {

	public PgsqlDatatypeTest(String testURI, String name, String queryFileURL, String resultFileURL, 
			String owlFileURL, String obdaFileURL, String parameterFileURL) {
		super(testURI, name, queryFileURL, resultFileURL, owlFileURL, obdaFileURL, parameterFileURL);
	}

	public static Test suite() throws Exception {
		return QuestDatatypeTestUtils.suite(new Factory() {
			@Override
			public PgsqlDatatypeTest createQuestDatatypeTest(String testURI, String name, String queryFileURL, 
					String resultFileURL, String owlFileURL, String obdaFileURL) {
				return new PgsqlDatatypeTest(testURI, name, queryFileURL, resultFileURL, owlFileURL, obdaFileURL, "");
			}
			@Override
			public PgsqlDatatypeTest createQuestDatatypeTest(String testURI, String name, String queryFileURL, 
					String resultFileURL, String owlFileURL, String obdaFileURL, String parameterFileURL) {
				return new PgsqlDatatypeTest(testURI, name, queryFileURL, resultFileURL, owlFileURL, obdaFileURL, parameterFileURL);
			}
			@Override
			public String getMainManifestFile() {
				return "/testcases-datatypes/manifest-datatype-pgsql.ttl";
			}
		});
	}
}
