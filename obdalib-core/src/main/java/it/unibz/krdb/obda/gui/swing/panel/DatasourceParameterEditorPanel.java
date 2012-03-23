/***
 * Copyright (c) 2008, Mariano Rodriguez-Muro. All rights reserved.
 * 
 * The OBDA-API is licensed under the terms of the Lesser General Public License
 * v.3 (see OBDAAPI_LICENSE.txt for details). The components of this work
 * include:
 * 
 * a) The OBDA-API developed by the author and licensed under the LGPL; and, b)
 * third-party components licensed under terms that may be different from those
 * of the LGPL. Information about such licenses can be found in the file named
 * OBDAAPI_3DPARTY-LICENSES.txt.
 */

package it.unibz.krdb.obda.gui.swing.panel;

import it.unibz.krdb.obda.gui.swing.utils.DatasourceSelectorListener;
import it.unibz.krdb.obda.model.OBDADataSource;
import it.unibz.krdb.obda.model.OBDAException;
import it.unibz.krdb.obda.model.OBDAModel;
import it.unibz.krdb.obda.model.impl.OBDADataFactoryImpl;
import it.unibz.krdb.obda.model.impl.RDBMSourceParameterConstants;
import it.unibz.krdb.sql.JDBCConnectionManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DatasourceParameterEditorPanel extends javax.swing.JPanel implements DatasourceSelectorListener {

	private static final long serialVersionUID = 3506358479342412849L;

	private OBDADataSource selectedDataSource = null;

	private OBDAModel obdaModel = null;

	private DatasourceSelector selector = null;

	/** Creates new form DatasourceParameterEditorPanel */
	public DatasourceParameterEditorPanel(OBDAModel model) {
		initComponents();
		setDatasourcesController(model);
		enableFields(false);
	}

	public void setDatasourcesController(OBDAModel model) {
		obdaModel = model;
		addDataSourceSelector();
		resetTextFields();
	}

	private void addDataSourceSelector() {
		selector = new DatasourceSelector(obdaModel);
		selector.addDatasourceListListener(this);

		pnlDataSourceSelector.add(selector, BorderLayout.CENTER);
	}

	private void resetTextFields() {
		txtJdbcUrl.setText("");
		txtDatabasePassword.setText("");
		txtDatabaseUsername.setText("");
		txtJdbcDriver.setText("");
	}

	private void enableFields(boolean value) {
		txtJdbcUrl.setEnabled(value);
		txtDatabasePassword.setEnabled(value);
		txtDatabaseUsername.setEnabled(value);
		txtJdbcDriver.setEnabled(value);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		pnlDataSourceSettings = new javax.swing.JPanel();
		pnlDataSourceInfo = new javax.swing.JPanel();
		lblDataSourceName = new javax.swing.JLabel();
		pnlDataSourceSelector = new javax.swing.JPanel();
		lblDataSourceType = new javax.swing.JLabel();
		lblDataSourceTypeValue = new javax.swing.JLabel();
		lblMappingType = new javax.swing.JLabel();
		lblMappingTypeValue = new javax.swing.JLabel();
		pnlDataSourceParameters = new javax.swing.JPanel();
		lblJdbcUrl = new javax.swing.JLabel();
		txtJdbcUrl = new javax.swing.JTextField();
		lblDatabaseUsername = new javax.swing.JLabel();
		txtDatabaseUsername = new javax.swing.JTextField();
		lblDatabasePassword = new javax.swing.JLabel();
		lblJdbcDriver = new javax.swing.JLabel();
		txtJdbcDriver = new javax.swing.JTextField();
		txtDatabasePassword = new javax.swing.JPasswordField();
		pnlTestConnection = new javax.swing.JPanel();
		cmdTestConnection = new javax.swing.JButton();
		lblConnectionStatus = new javax.swing.JLabel();
		pnlCommandButton = new javax.swing.JPanel();
		cmdNew = new javax.swing.JButton();
		cmdRemove = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(540, 270));
		setPreferredSize(new java.awt.Dimension(540, 270));
		setLayout(new java.awt.BorderLayout());

		pnlDataSourceSettings.setBorder(javax.swing.BorderFactory.createTitledBorder("Datasource Settings"));
		pnlDataSourceSettings.setAutoscrolls(true);
		pnlDataSourceSettings.setMinimumSize(new java.awt.Dimension(540, 250));
		pnlDataSourceSettings.setPreferredSize(new java.awt.Dimension(540, 250));
		pnlDataSourceSettings.setLayout(new java.awt.BorderLayout());

		pnlDataSourceInfo.setAutoscrolls(true);
		pnlDataSourceInfo.setMaximumSize(new java.awt.Dimension(32767, 23));
		pnlDataSourceInfo.setMinimumSize(new java.awt.Dimension(540, 70));
		pnlDataSourceInfo.setPreferredSize(new java.awt.Dimension(540, 70));
		pnlDataSourceInfo.setLayout(new java.awt.GridBagLayout());

		lblDataSourceName.setBackground(new java.awt.Color(153, 153, 153));
		lblDataSourceName.setFont(new java.awt.Font("Arial", 1, 11));
		lblDataSourceName.setForeground(new java.awt.Color(153, 153, 153));
		lblDataSourceName.setText("Data Source Name:");
		lblDataSourceName.setFocusable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
		pnlDataSourceInfo.add(lblDataSourceName, gridBagConstraints);

		pnlDataSourceSelector.setLayout(new java.awt.BorderLayout());
		pnlDataSourceSelector.setPreferredSize(new Dimension(300, 25));
		pnlDataSourceSelector.setMinimumSize(new Dimension(300, 25));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = gridBagConstraints.WEST;
		// gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		// gridBagConstraints.weightx = 1;
		pnlDataSourceInfo.add(pnlDataSourceSelector, gridBagConstraints);

		lblDataSourceType.setBackground(new java.awt.Color(153, 153, 153));
		lblDataSourceType.setFont(new java.awt.Font("Arial", 1, 11));
		lblDataSourceType.setForeground(new java.awt.Color(153, 153, 153));
		lblDataSourceType.setText("Type:");
		lblDataSourceType.setFocusable(false);
		lblDataSourceType.setMaximumSize(new java.awt.Dimension(119, 14));
		lblDataSourceType.setMinimumSize(new java.awt.Dimension(119, 14));
		lblDataSourceType.setPreferredSize(new java.awt.Dimension(119, 14));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
		pnlDataSourceInfo.add(lblDataSourceType, gridBagConstraints);

		lblDataSourceTypeValue.setFont(new java.awt.Font("Arial", 0, 11));
		lblDataSourceTypeValue.setFocusable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		pnlDataSourceInfo.add(lblDataSourceTypeValue, gridBagConstraints);

		lblMappingType.setBackground(new java.awt.Color(153, 153, 153));
		lblMappingType.setFont(new java.awt.Font("Arial", 1, 11));
		lblMappingType.setForeground(new java.awt.Color(153, 153, 153));
		lblMappingType.setText("Mapping Type:");
		lblMappingType.setFocusable(false);
		lblMappingType.setMaximumSize(new java.awt.Dimension(119, 14));
		lblMappingType.setMinimumSize(new java.awt.Dimension(119, 14));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
		pnlDataSourceInfo.add(lblMappingType, gridBagConstraints);

		lblMappingTypeValue.setFont(new java.awt.Font("Arial", 0, 11));
		lblMappingTypeValue.setFocusable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		pnlDataSourceInfo.add(lblMappingTypeValue, gridBagConstraints);

		pnlDataSourceSettings.add(pnlDataSourceInfo, java.awt.BorderLayout.NORTH);

		pnlDataSourceParameters.setAlignmentX(5.0F);
		pnlDataSourceParameters.setAlignmentY(5.0F);
		pnlDataSourceParameters.setAutoscrolls(true);
		// pnlDataSourceParameters.setFocusTraversalPolicyProvider(true);
		pnlDataSourceParameters.setMaximumSize(new java.awt.Dimension(6404444, 34452345));
		pnlDataSourceParameters.setMinimumSize(new java.awt.Dimension(540, 110));
		pnlDataSourceParameters.setPreferredSize(new java.awt.Dimension(540, 110));
		pnlDataSourceParameters.setLayout(new java.awt.GridBagLayout());

		lblJdbcUrl.setFont(new java.awt.Font("Arial", 1, 11));
		lblJdbcUrl.setForeground(new java.awt.Color(153, 153, 153));
		lblJdbcUrl.setText("  JDBC URL:");
		lblJdbcUrl.setFocusable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		pnlDataSourceParameters.add(lblJdbcUrl, gridBagConstraints);

		txtJdbcUrl.setMaximumSize(new java.awt.Dimension(25, 2147483647));
		txtJdbcUrl.setMinimumSize(new java.awt.Dimension(180, 19));
		txtJdbcUrl.setName("somename"); // NOI18N
		txtJdbcUrl.setPreferredSize(new java.awt.Dimension(180, 19));
		txtJdbcUrl.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				fieldChangeHandler(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 0);
		pnlDataSourceParameters.add(txtJdbcUrl, gridBagConstraints);

		lblDatabaseUsername.setFont(new java.awt.Font("Arial", 1, 11));
		lblDatabaseUsername.setForeground(new java.awt.Color(153, 153, 153));
		lblDatabaseUsername.setText("  Database Username:");
		lblDatabaseUsername.setFocusable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		pnlDataSourceParameters.add(lblDatabaseUsername, gridBagConstraints);

		// txtDatabaseUsername.setFocusTraversalPolicy(getFocusTraversalPolicy());
		txtDatabaseUsername.setMaximumSize(new java.awt.Dimension(25, 2147483647));
		txtDatabaseUsername.setMinimumSize(new java.awt.Dimension(180, 19));
		txtDatabaseUsername.setName("somename"); // NOI18N
		txtDatabaseUsername.setPreferredSize(new java.awt.Dimension(180, 19));
		txtDatabaseUsername.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				fieldChangeHandler(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 0);
		pnlDataSourceParameters.add(txtDatabaseUsername, gridBagConstraints);

		lblDatabasePassword.setFont(new java.awt.Font("Arial", 1, 11));
		lblDatabasePassword.setForeground(new java.awt.Color(153, 153, 153));
		lblDatabasePassword.setText("  Database Password:");
		lblDatabasePassword.setFocusable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		pnlDataSourceParameters.add(lblDatabasePassword, gridBagConstraints);

		lblJdbcDriver.setFont(new java.awt.Font("Arial", 1, 11));
		lblJdbcDriver.setForeground(new java.awt.Color(153, 153, 153));
		lblJdbcDriver.setText("  JDBC Driver:");
		lblJdbcDriver.setFocusable(false);
		lblJdbcDriver.setMaximumSize(new java.awt.Dimension(120, 14));
		lblJdbcDriver.setMinimumSize(new java.awt.Dimension(120, 14));
		lblJdbcDriver.setPreferredSize(new java.awt.Dimension(120, 14));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		pnlDataSourceParameters.add(lblJdbcDriver, gridBagConstraints);

		txtJdbcDriver.setMaximumSize(new java.awt.Dimension(25, 2147483647));
		txtJdbcDriver.setMinimumSize(new java.awt.Dimension(180, 19));
		txtJdbcDriver.setName("somename"); // NOI18N
		txtJdbcDriver.setPreferredSize(new java.awt.Dimension(180, 19));
		txtJdbcDriver.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				fieldChangeHandler(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 0);
		pnlDataSourceParameters.add(txtJdbcDriver, gridBagConstraints);

		txtDatabasePassword.setMinimumSize(new java.awt.Dimension(180, 19));
		txtDatabasePassword.setPreferredSize(new java.awt.Dimension(180, 19));
		txtDatabasePassword.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				fieldChangeHandler(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 0);
		pnlDataSourceParameters.add(txtDatabasePassword, gridBagConstraints);

		pnlDataSourceSettings.add(pnlDataSourceParameters, java.awt.BorderLayout.CENTER);

		pnlTestConnection.setMinimumSize(new java.awt.Dimension(540, 33));
		pnlTestConnection.setPreferredSize(new java.awt.Dimension(540, 33));
		pnlTestConnection.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		cmdTestConnection.setText("Test Connection");
		cmdTestConnection.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdTestConnectionActionPerformed(evt);
			}
		});
		pnlTestConnection.add(cmdTestConnection);
		pnlTestConnection.add(lblConnectionStatus);

		pnlDataSourceSettings.add(pnlTestConnection, java.awt.BorderLayout.SOUTH);

		add(pnlDataSourceSettings, java.awt.BorderLayout.CENTER);

		pnlCommandButton.setMinimumSize(new java.awt.Dimension(540, 33));
		pnlCommandButton.setPreferredSize(new java.awt.Dimension(540, 33));
		pnlCommandButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

		cmdNew.setText("New...");
		cmdNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdNewActionPerformed(evt);
			}
		});
		pnlCommandButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlCommandButton.add(cmdNew);

		cmdRemove.setText("Remove..");
		cmdRemove.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdRemoveActionPerformed(evt);
			}
		});
		pnlCommandButton.add(cmdRemove);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 2;
		gridBagConstraints.anchor = gridBagConstraints.WEST;
		pnlDataSourceInfo.add(pnlCommandButton, gridBagConstraints);

		// add(pnlCommandButton, java.awt.BorderLayout.SOUTH);
	}// </editor-fold>//GEN-END:initComponents

	private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdNewActionPerformed
		while (true) {
			String name = JOptionPane.showInputDialog(this, "Insert an identifier for the new data source:", null);
			if (name == null) {
				return;
			}

			if (!name.isEmpty()) {
				URI uri = createUri(name);
				if (uri != null) {
					if (!obdaModel.containsSource(uri)) {
						OBDADataSource source = OBDADataFactoryImpl.getInstance().getDataSource(uri);
						obdaModel.addSource(source);
						selector.set(source);
						return;
					} else {
						JOptionPane.showMessageDialog(this, "The data source ID already used", "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "The data source ID cannot be blank", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
	}// GEN-LAST:event_cmdNewActionPerformed

	private void cmdRemoveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdRemoveActionPerformed
		OBDADataSource ds = selector.getSelectedDataSource();
		if (ds == null) {
			JOptionPane.showMessageDialog(this, "Select a data source to proceed", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}

		int answer = JOptionPane.showConfirmDialog(this, "Are you sure want to delete this data source?", "Delete Confirmation",
				JOptionPane.OK_CANCEL_OPTION);
		if (answer == JOptionPane.OK_OPTION) {
			obdaModel.removeSource(ds.getSourceID());
		}
	}// GEN-LAST:event_cmdRemoveActionPerformed

	private void cmdTestConnectionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdTestConnectionActionPerformed
		OBDADataSource ds = selector.getSelectedDataSource();
		if (ds == null) {
			JOptionPane.showMessageDialog(this, "Select a data source to proceed", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}

		JDBCConnectionManager connm = JDBCConnectionManager.getJDBCConnectionManager();
		try {
			Connection conn = connm.getConnection(selectedDataSource);
			if (conn == null)
				throw new SQLException("Error connecting to the database");
			lblConnectionStatus.setForeground(Color.GREEN);
			lblConnectionStatus.setText("Connection is OK");
		} catch (SQLException e) { // if fails
			lblConnectionStatus.setForeground(Color.RED);
			lblConnectionStatus.setText(String.format("%s (ERR-CODE: %s)", e.getMessage(), e.getErrorCode()));
		}
	}// GEN-LAST:event_cmdTestConnectionActionPerformed

	private URI createUri(String name) {
		URI uri = null;
		try {
			uri = URI.create(name);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Invalid identifier string", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		return uri;
	}

	private void fieldChangeHandler(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_fieldChangeHandler

		if (selectedDataSource == null) {
			JOptionPane.showMessageDialog(this, "Select a data source to proceed", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		JDBCConnectionManager man = JDBCConnectionManager.getJDBCConnectionManager();
		try {
			man.closeConnection(selectedDataSource);
		} catch (OBDAException e) {
			//do nothing
		} catch (SQLException e) {
			//do nothing
		}
		
		// currentsrc.setUri(fieldURI.getText());
		selectedDataSource.setParameter(RDBMSourceParameterConstants.DATABASE_USERNAME, txtDatabaseUsername.getText());
		selectedDataSource.setParameter(RDBMSourceParameterConstants.DATABASE_PASSWORD, new String(txtDatabasePassword.getPassword()));
		selectedDataSource.setParameter(RDBMSourceParameterConstants.DATABASE_DRIVER, txtJdbcDriver.getText());
		selectedDataSource.setParameter(RDBMSourceParameterConstants.DATABASE_URL, txtJdbcUrl.getText());
		// currentDS.setParameter(RDBMSsourceParameterConstants.ONTOLOGY_URI,
		// apic.getCurrentOntologyURI().toString());
		obdaModel.fireSourceParametersUpdated();

		return;
	}// GEN-LAST:event_fieldChangeHandler

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cmdNew;
	private javax.swing.JButton cmdRemove;
	private javax.swing.JButton cmdTestConnection;
	private javax.swing.JLabel lblConnectionStatus;
	private javax.swing.JLabel lblDataSourceName;
	private javax.swing.JLabel lblDataSourceType;
	private javax.swing.JLabel lblDataSourceTypeValue;
	private javax.swing.JLabel lblDatabasePassword;
	private javax.swing.JLabel lblDatabaseUsername;
	private javax.swing.JLabel lblJdbcDriver;
	private javax.swing.JLabel lblJdbcUrl;
	private javax.swing.JLabel lblMappingType;
	private javax.swing.JLabel lblMappingTypeValue;
	private javax.swing.JPanel pnlCommandButton;
	private javax.swing.JPanel pnlDataSourceInfo;
	private javax.swing.JPanel pnlDataSourceParameters;
	private javax.swing.JPanel pnlDataSourceSelector;
	private javax.swing.JPanel pnlDataSourceSettings;
	private javax.swing.JPanel pnlTestConnection;
	private javax.swing.JPasswordField txtDatabasePassword;
	private javax.swing.JTextField txtDatabaseUsername;
	private javax.swing.JTextField txtJdbcDriver;
	private javax.swing.JTextField txtJdbcUrl;

	// End of variables declaration//GEN-END:variables

	private void currentDatasourceChange(OBDADataSource previousdatasource, OBDADataSource currentsource) {

		if (currentsource == null) {
			lblDataSourceTypeValue.setText("");
			lblMappingTypeValue.setText("");
			txtJdbcDriver.setText("");
			txtDatabaseUsername.setText("");
			txtDatabasePassword.setText("");
			txtJdbcUrl.setText("");
			lblDataSourceTypeValue.setEnabled(false);
			lblMappingTypeValue.setEnabled(false);
			txtJdbcDriver.setEnabled(false);
			txtDatabaseUsername.setEnabled(false);
			txtDatabasePassword.setEnabled(false);
			txtJdbcUrl.setEnabled(false);
			lblConnectionStatus.setText("");
			selectedDataSource = null;
		} else {

			/*******************************************************************
			 * Updating the GUI fields with the sources info
			 * 
			 */
			lblDataSourceTypeValue.setText("Relational Database");
			lblMappingTypeValue.setText("OBDA Mappings");
			txtJdbcDriver.setText(currentsource.getParameter(RDBMSourceParameterConstants.DATABASE_DRIVER));
			txtDatabaseUsername.setText(currentsource.getParameter(RDBMSourceParameterConstants.DATABASE_USERNAME));
			txtDatabasePassword.setText(currentsource.getParameter(RDBMSourceParameterConstants.DATABASE_PASSWORD));
			txtJdbcUrl.setText(currentsource.getParameter(RDBMSourceParameterConstants.DATABASE_URL));
			lblDataSourceTypeValue.setEnabled(true);
			lblMappingTypeValue.setEnabled(true);
			txtJdbcDriver.setEnabled(true);
			txtDatabaseUsername.setEnabled(true);
			txtDatabasePassword.setEnabled(true);
			txtJdbcUrl.setEnabled(true);
			lblConnectionStatus.setText("");
			selectedDataSource = currentsource;
		}
	}

	@Override
	public void datasourceChanged(OBDADataSource oldSource, OBDADataSource newSource) {
		currentDatasourceChange(oldSource, newSource);
		if (newSource == null)
			enableFields(false);
		else
			enableFields(true);

	}
}