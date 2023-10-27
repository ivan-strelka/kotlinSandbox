package libs.jackson

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.util.*

class JacksonJsonUtils {

    /**
     * Default JSON serializer/deserializer
     * By default NULL fields are omitted during serialization
     * By default the error appears if there unknown fields in JSON string
     * @return Default JSON serializer/deserializer
     */
    companion object {
        fun defaultMapper(): ObjectMapper {
            return ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                .registerModule(
                    KotlinModule.Builder()
                        .withReflectionCacheSize(512)
                        .configure(KotlinFeature.NullToEmptyCollection, false)
                        .configure(KotlinFeature.NullToEmptyMap, false)
                        .configure(KotlinFeature.NullIsSameAsDefault, false)
                        .configure(KotlinFeature.SingletonSupport, false)
                        .configure(KotlinFeature.StrictNullChecks, false)
                        .build()
                )
        }


        /**
         * Convert json string to desired class with default rules
         * @param input json string
         * @param tClass required class
         * @param <T>
         * @return Instance of class
         * @see .defaultMapper
        </T> */
        fun <T> fromJson(input: String?, tClass: Class<T>?): T {
            return try {
                defaultMapper().readValue(input, tClass)
            } catch (e: JsonProcessingException) {
                throw RuntimeException(e)
            }
        }

        /**
         * Convert json string to regular JsonNode with default rules
         * @param input json string
         * @return JsonNode
         * @see .defaultMapper
         */
        fun fromJson(input: String?): JsonNode {
            return try {
                defaultMapper().readTree(input)
            } catch (e: JsonProcessingException) {
                throw java.lang.RuntimeException(e)
            }
        }

        /**
         * Convert json string to regular JsonNode with default rules, except the NULL values
         * Here is NULL values will not be omitted
         * @param input json string
         * @return JsonNode
         * @see .defaultMapper
         */
        fun fromJsonWithNulls(input: String?): JsonNode? {
            return try {
                defaultMapper().setSerializationInclusion(JsonInclude.Include.ALWAYS).readTree(input)
            } catch (e: JsonProcessingException) {
                throw java.lang.RuntimeException(e)
            }
        }

        /**
         * Convert json string to the desired class with default rules, except the NULL values
         * Here is NULL values will not be omitted
         *
         * @param input json string
         * @return T
         * @see .defaultMapper
         */
        fun <T> fromJsonWithNulls(input: String, tClass: Class<T>): T {
            return try {
                defaultMapper().setSerializationInclusion(JsonInclude.Include.ALWAYS)
                    .readValue(input, tClass)
            } catch (e: JsonProcessingException) {
                throw java.lang.RuntimeException(e)
            }
        }

        /**
         * Convert json string to the JSON object with default rules
         *
         * @param input json string
         * @return Json Object
         * @see .defaultMapper
         */
        fun fromJsonAsNode(input: String?): ObjectNode {
            return fromJson(input) as ObjectNode
        }

        /**
         * Convert json string to the JSON array with default rules
         * @param input json string
         * @return Json array
         * @see .defaultMapper
         */
        fun fromJsonAsArray(input: String?): ArrayNode {
            return fromJson(input) as ArrayNode
        }

        /**
         * Convert json string to the desired class with default rules, except unknown fields policy
         * In case of unknown field it will be ignored instead of error
         * @param input json string
         * @param tClass Desired class
         * @return Instance of tClass
         * @see .defaultMapper
         */
        fun <T> fromJsonIgnoreUnknownFields(input: String, tClass: Class<T>): T {
            return try {
                defaultMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(input, tClass)
            } catch (e: JsonProcessingException) {
                throw java.lang.RuntimeException(e)
            }
        }

        /**
         * Convert json string to the regular Json node with default rules, except unknown fields policy
         * In case of unknown field it will be ignored instead of error
         * @param input json string
         * @return Instance of tClass
         * @see .defaultMapper
         */
        fun fromJsonIgnoreUnknownFields(input: String?): JsonNode {
            return try {
                defaultMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readTree(input)
            } catch (e: JsonProcessingException) {
                throw java.lang.RuntimeException(e)
            }
        }

        /**
         * Convert json string array to the list of desired class with default rules, except unknown policy
         * If json field is unknown it will be ignored instead of error
         * @param input json string with array
         * @param tClass Class of array's instances
         * @param <T>
         * @return List of instances
        </T> */
        fun <T> fromJsonAsListIgnoreUnknownFields(input: String, tClass: Class<T>): List<T> {
            val arrayNode = fromJsonAsArray(input)
            val results: MutableList<T> = LinkedList()
            for (i in 0 until arrayNode.size()) {
                results.add(fromJsonIgnoreUnknownFields(arrayNode[i].toString(), tClass))
            }
            return results
        }

        /**
         * Convert the object to json string with default rules
         * @param input json string
         * @return Json string
         * @see .defaultMapper
         */
        fun toJson(input: Any): String {
            return try {
                defaultMapper().writeValueAsString(input)
            } catch (e: JsonProcessingException) {
                throw java.lang.RuntimeException(e)
            }
        }

        /**
         * Covert the object to JSON string with definition of NULL values
         * @param input Object
         * @return json string
         */
        fun toJsonWithNulls(input: Any?): String? {
            return try {
                defaultMapper()
                    .setSerializationInclusion(JsonInclude.Include.ALWAYS)
                    .writeValueAsString(input)
            } catch (e: JsonProcessingException) {
                throw java.lang.RuntimeException(e)
            }
        }
    }
}