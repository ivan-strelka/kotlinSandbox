package kotlinCore.stream.course1.ex

import org.junit.jupiter.api.Test

class Ex0 {


    data class A(
        val testName: String,
        val testList: List<B>
    ) {
        data class B(
            val testString: String,
            val testB: String
        )
    }

    val a = listOf(
        A("asd", listOf(A.B("dghfjsg", "ahdgj"))),
        A("asdgh", listOf(A.B("yuewydgh", "djkhfj"))),
        A("sgf", listOf(A.B("opuiu", "sajhja")))
    )

    @Test
    fun testName() {
        val map = a.filter { it.testName == "asd" }.flatMap { it.testList.filter { it.testString == "dghfjsg" } }
    }


//
//    fun xgetAllProductRequestTest() {
//
//
//        val allProductRequest =
//            apiFactory.get(company.getCompanyLeader()).marketplace.productRequests
//                .getAllProductRequest(company.id!!)
//                .model.value
//
//        val flatMap = allProductRequest.flatMap { it.requests }
//
//        val allProductRequest122 =
//            allProductRequest.filter { it.requests.isNotEmpty() }.flatMap { it.requests }
//
//        val allProductRequest212e =
//            allProductRequest.map { it.product }
//
//
//        val allProductRequest3 =
//            allProductRequest.filter { it.product.code == "InternetAcquiring" }
//
//        val allProductRequest4 =
//            allProductRequest.filter { p -> p.product.code == "MerchantAcquiring" }
//
//        val allProductRequest4123 =
//            allProductRequest.filter { p -> p.product.code == "MerchantAcquiring" }
//                .map { it -> it.requests.filter { it.id.isNotEmpty() } }
//
//        val allProductRequest4d23 =
//            allProductRequest.filter { it.requests.isNotEmpty() }.map { it.product.code.lowercase() }
//
//        ActiveProductCode.values().forEach { code ->
//            Assertions.assertThat(allProductRequest4d23).containsAnyOf(code.type)
//        }
//
//
//        val target = mutableListOf<Int>()
//        listOf(1, 2, 3, 4, 5).filterTo(target) { n -> n % 2 == 0 }
//
//    }
}