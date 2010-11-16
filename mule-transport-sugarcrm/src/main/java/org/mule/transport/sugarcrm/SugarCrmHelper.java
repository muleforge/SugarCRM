/*
 * $Id: SugarCrmHelper.java 1009 2010-09-22 15:55:54Z gdimech $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.sugarcrm;

import com.sugarcrm.sugarcrm.EntryList;
import com.sugarcrm.sugarcrm.FieldList;
import com.sugarcrm.sugarcrm.GetEntryListResponseType;
import com.sugarcrm.sugarcrm.GetEntryResponseType;
import com.sugarcrm.sugarcrm.GetModuleFieldsResponseType;
import com.sugarcrm.sugarcrm.LogoutResponseType;
import com.sugarcrm.sugarcrm.NewModuleFields;
import com.sugarcrm.sugarcrm.SetEntryResponseType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.xerces.dom.ElementNSImpl;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SugarCrmHelper {
	
	protected static XPathFactory factory = XPathFactory.newInstance();

	protected static String extractFieldName(Node itemNode) {

		NodeList nodeList = itemNode.getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node n = nodeList.item(i);
			if (n.getLocalName() == "name")
			{
				return n.getTextContent();
			}
		}

		return null;
	}

	public static ArrayList<String> convertSugarCrmModuleFieldsResult(
			GetModuleFieldsResponseType moduleFieldsResponse)
			throws XPathExpressionException {

		FieldList entryList = moduleFieldsResponse.getReturn().getModuleFields();
		List<Object> any = entryList.getAny();

		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < any.size(); i++) {
			Node nameValueListNode = ((ElementNSImpl) any.get(i));

			result.add(extractFieldName(nameValueListNode));
		}
		return result;
	}

	protected static Node extractModuleFieldsNode(ElementNSImpl element)
			throws XPathExpressionException {
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//module_fields");

		return (Node) expr.evaluate(element, XPathConstants.NODE);
	}

	// ////////////////////

	protected static HashMap<String, String> convertNameValueListNodeToHashMap(
			Node nameValueListNode) {
		HashMap<String, String> result = new HashMap<String, String>();
		NodeList nodeList = nameValueListNode.getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node n = nodeList.item(i);
			String fieldName = n.getChildNodes().item(0).getTextContent();
			String fieldValue = n.getChildNodes().item(1).getTextContent();

			result.put(fieldName, fieldValue);
		}

		return result;
	}

	protected static Node extractNameValueListNode(ElementNSImpl element)
			throws XPathExpressionException {
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//name_value_list");

		return (Node) expr.evaluate(element, XPathConstants.NODE);
	}

	public static HashMap<String, String> convertSugarCrmSingleResult(
			GetEntryResponseType entryResponse) throws XPathExpressionException {
		EntryList entryList = entryResponse.getReturn().getEntryList();
		List<Object> any = entryList.getAny();

		Node nameValueListNode = (Node) extractNameValueListNode((ElementNSImpl) any
				.get(0));

		return convertNameValueListNodeToHashMap(nameValueListNode);
	}

	public static List<HashMap<String, String>> convertSugarCrmMultipleResult(
			GetEntryListResponseType entryResponse)
			throws XPathExpressionException {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		EntryList entryList = entryResponse.getReturn().getEntryList();
		List<Object> any = entryList.getAny();

		for (int i = 0; i < any.size(); i++) {
			Node nameValueListNode = (Node) extractNameValueListNode((ElementNSImpl) any
					.get(i));
			list.add(convertNameValueListNodeToHashMap(nameValueListNode));
		}

		return list;
	}

	public static List<HashMap<String, String>> convertSugarCrmMultipleResult(
			GetModuleFieldsResponseType entryResponse)
			throws XPathExpressionException {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		FieldList fieldList = entryResponse.getReturn().getModuleFields();
		List<Object> any = fieldList.getAny();

		for (int i = 0; i < any.size(); i++) {
			Node nameValueListNode = (Node) extractNameValueListNode((ElementNSImpl) any
					.get(i));
			list.add(convertNameValueListNodeToHashMap(nameValueListNode));
		}

		return list;
	}
}
