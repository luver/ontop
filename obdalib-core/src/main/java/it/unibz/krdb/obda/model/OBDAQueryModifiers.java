/*
 * Copyright (C) 2009-2013, Free University of Bozen Bolzano
 * This source code is available under the terms of the Affero General Public
 * License v3.
 * 
 * Please see LICENSE.txt for full license terms, including the availability of
 * proprietary exceptions.
 */
package it.unibz.krdb.obda.model;

import java.util.ArrayList;
import java.util.List;

public class OBDAQueryModifiers {

	private boolean isDistinct;

	private long limit;
	private long offset;

	private List<OrderCondition> orderConditions;

	public OBDAQueryModifiers() {
		isDistinct = false;
		limit = -1;
		offset = -1;
		orderConditions = new ArrayList<OrderCondition>();
	}

	public OBDAQueryModifiers clone() {
		OBDAQueryModifiers clone = new OBDAQueryModifiers();
		clone.isDistinct = isDistinct;
		clone.limit = limit;
		clone.offset = offset;
		for (OrderCondition c : orderConditions) {
			try {
				clone.orderConditions.add(c.clone());
			} catch (CloneNotSupportedException e) {
				throw new RuntimeException(e);
			}
		}
		return clone;
	}

	public void copy(OBDAQueryModifiers other) {
		isDistinct = other.isDistinct;
		limit = other.limit;
		offset = other.offset;
		orderConditions.addAll(other.orderConditions);
	}

	public void setDistinct() {
		isDistinct = true;
	}

	public boolean isDistinct() {
		return isDistinct;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public long getLimit() {
		return limit;
	}

	public boolean hasLimit() {
		return limit != -1 ? true : false;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public long getOffset() {
		return offset;
	}

	public boolean hasOffset() {
		return offset != -1 ? true : false;
	}

	public void addOrderCondition(Variable var, int direction) {
		OrderCondition condition = new OrderCondition(var, direction);
		orderConditions.add(condition);
	}

	public List<OrderCondition> getSortConditions() {
		return orderConditions;
	}

	public boolean hasOrder() {
		return !orderConditions.isEmpty() ? true : false;
	}

	public boolean hasModifiers() {
		return isDistinct || hasLimit() || hasOffset() || hasOrder();
	}

	/**
	 * A helper class to store the sort conditions
	 */
	public class OrderCondition implements Cloneable {
		public static final int ORDER_ASCENDING = 1;
		public static final int ORDER_DESCENDING = 2;

		private Variable var;
		private int direction;

		OrderCondition(Variable var, int direction) {
			this.var = var;
			this.direction = direction;
		}

		public Variable getVariable() {
			return var;
		}

		public int getDirection() {
			return direction;
		}

		@Override
		public OrderCondition clone() throws CloneNotSupportedException {
			return (OrderCondition) super.clone();
		}
	}
}
