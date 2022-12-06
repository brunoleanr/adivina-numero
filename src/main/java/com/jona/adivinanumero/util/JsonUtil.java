package com.jona.adivinanumero.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser.Feature;

public class JsonUtil {

	private static final ObjectMapper mapper = new ObjectMapper().configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

	public static String getStringValue(String jsonData, String tag) throws IOException {
		if (jsonData != null && !jsonData.isEmpty()) {
			JsonNode node = null;
			node = mapper.readTree(jsonData);
			String value = null;
			if (node.isArray()) {
				ArrayNode objectNode = (ArrayNode) node;
				value = objectNode.toString();
			} else
				value = getStringValue(node, tag);
			return value;
		}
		return null;
	}

	private static String getStringValue(JsonNode node, String tag) {
		JsonNode Jsonvalue = node.get(tag);
		String value = Jsonvalue != null && !Jsonvalue.isNull() ? Jsonvalue.asText() : null;

		return value;
	}

	public static String toString(Object object) throws Exception {
		ObjectReader reader = mapper.reader();

		String jsonResponse = null;
		try {
			jsonResponse = mapper.writeValueAsString(object);
			JsonNode node = reader.readTree(jsonResponse);
			if (node.isArray()) {
				ArrayNode objectNode = (ArrayNode) node;
				return objectNode.toString();
			} else {
				ObjectNode objectNode = (ObjectNode) node;
				return objectNode.toString();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static ArrayNode arrayStringToArrayNode(List<String> items) throws IOException {
		if (items.size() > 0) {
			ArrayNode retorno = mapper.createArrayNode();
			for (String item : items) {
				JsonNode node = mapper.reader().readTree(item);
				if (node.isArray()) {
					ArrayNode objectNode = (ArrayNode) node;
					retorno.add(objectNode);
				} else {
					ObjectNode objectNode = (ObjectNode) node;
					retorno.add(objectNode);
				}
			}
			return retorno;
		} else {
			return null;
		}
	}

	private static Boolean getBooleanValue(JsonNode node, String tag) {
		JsonNode Jsonvalue = node.get(tag);
		Boolean value = Jsonvalue != null && !Jsonvalue.isNull() ? Jsonvalue.asBoolean() : null;

		return value;
	}

	public static Boolean getBooleanValue(String jsonData, String tag) throws IOException {
		if (jsonData != null && !jsonData.isEmpty()) {
			JsonNode node = null;
			node = mapper.readTree(jsonData);
			Boolean value = getBooleanValue(node, tag);
			return value;
		}
		return false;
	}

	private static boolean getBoolValue(JsonNode node, String tag) {
		JsonNode Jsonvalue = node.get(tag);
		Boolean value = Jsonvalue != null && !Jsonvalue.isNull() ? Jsonvalue.asBoolean() : false;

		return value;
	}

	public static boolean getBoolValue(String jsonData, String tag) throws IOException {
		if (jsonData != null && !jsonData.isEmpty()) {
			JsonNode node = null;
			node = mapper.readTree(jsonData);
			boolean value = getBoolValue(node, tag);
			return value;
		}
		return false;
	}

	private static Long getLongValue(JsonNode node, String tag) {
		JsonNode Jsonvalue = node.get(tag);
		Long value = (Jsonvalue != null && !Jsonvalue.isNull() && !Jsonvalue.asText().isEmpty()) ? Jsonvalue.asLong()
				: null;

		return value;
	}

	private static Double getDoubleValue(JsonNode node, String tag) {
		JsonNode Jsonvalue = node.get(tag);
		Double value = (Jsonvalue != null && !Jsonvalue.isNull() && !Jsonvalue.asText().isEmpty())
				? Jsonvalue.asDouble()
				: null;

		return value;
	}

	public static Double getDoubleValue(String jsonData, String tag) throws IOException {
		if (jsonData != null && !jsonData.isEmpty()) {
			JsonNode node = null;
			node = mapper.readTree(jsonData);
			Double value = getDoubleValue(node, tag);
			return value;
		}
		return null;
	}

	public static Long getLongValue(String jsonData, String tag) throws IOException {
		if (jsonData != null && !jsonData.isEmpty()) {
			JsonNode node = null;
			node = mapper.readTree(jsonData);
			Long value = getLongValue(node, tag);
			return value;
		}
		return null;
	}

	public static ObjectNode addArrayNode(Object parent, String nodeName, List<String> values) {
		ObjectReader reader = mapper.reader();
		String jsonResponse = null;
		try {
			jsonResponse = mapper.writeValueAsString(parent);
			JsonNode node = reader.readTree(jsonResponse);
			ObjectNode objectNode = (ObjectNode) node;
			ArrayNode array = mapper.valueToTree(values);
			objectNode.putArray(nodeName).addAll(array);
			return objectNode;
		} catch (IOException e) {
			return null;
		}
	}

	public static ObjectNode addNode(Object parent, String nodeName, Object values) {
		ObjectReader reader = mapper.reader();
		ObjectWriter writer = mapper.writer();
		String jsonResponse = null;
		try {
			jsonResponse = writer.writeValueAsString(parent);
			JsonNode node = reader.readTree(jsonResponse);
			ObjectNode objectNode = (ObjectNode) node;
			String valuesSt = writer.writeValueAsString(values);
			JsonNode valuesNode = reader.readTree(valuesSt);
			objectNode.set(nodeName, valuesNode);
			return objectNode;
		} catch (IOException e) {
			return null;
		}
	}

	public static ArrayNode addNodeToArrayNode(Object parent, String nodeName, Object values) {
		ObjectReader reader = mapper.reader();
		ObjectWriter writer = mapper.writer();
		String jsonResponse = null;
		try {
			jsonResponse = writer.writeValueAsString(parent);
			JsonNode node = reader.readTree(jsonResponse);
			ArrayNode objectArray = (ArrayNode) node;
			String valuesSt = writer.writeValueAsString(values);
			JsonNode valuesNode = reader.readTree(valuesSt);
			ObjectNode objectNode = mapper.createObjectNode();
			objectNode.set(nodeName, valuesNode);
			objectArray.add(objectNode);
			return objectArray;
		} catch (IOException e) {
			return null;
		}
	}

	public static ObjectNode addWrapper(Object parent, String nodeName) {
		ObjectWriter writer = mapper.writer();
		ObjectReader reader = mapper.reader();
		ObjectNode objectNode = null;
		try {
			String jsonResponse = writer.writeValueAsString(parent);
			JsonNode node = reader.readTree(jsonResponse);
			objectNode = mapper.createObjectNode();
			objectNode.set(nodeName, node);
		} catch (IOException e) {
			return null;
		}
		return objectNode;
	}

	public static String getSubNodo(String jsonData, String subPath, String hoja) throws IOException {
		JsonNode node = null;
		if (jsonData != null && !jsonData.isEmpty()) {
			node = mapper.readTree(jsonData);
			if (!subPath.isEmpty() && !hoja.isEmpty()) {
				JsonNode subNodo = node.at(subPath);
				if (subNodo != null) {
					JsonNode Jsonvalue = subNodo.get(hoja);
					String value = Jsonvalue != null && !Jsonvalue.isNull() ? Jsonvalue.asText() : null;
					return value;
				}
			}
		}
		return null;
	}

	public static String getJsonFromObject(Object transaccion)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(transaccion);
		JsonNode jsonNode = mapper.reader().readTree(requestJson);
		requestJson = mapper.writeValueAsString(jsonNode);
		return requestJson;
	}

}
