package ala

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.http.request.builder.HttpRequestBuilder

package object ala {
  val prodUrl = "https://images.ala.org.au"
  val devUrl = "https://images-dev.ala.org.au"
  val localUrl = "https://devt.ala.org.au/images"

  val baseUrl: String = localUrl

  val devIds: Array[String] = Array(
    "e2c1bb3e-4229-4688-9a2b-d2c2a5e08534",
    "38220392-4499-4df3-8638-e9e0e8cdfe81",
    "dd37a8e4-3234-4688-9e99-9247bc41fd03"
  )

  val localIds: Array[String] = Array(
    "2e218384-4998-4412-8dba-cee548987afa",
    "25734e4e-00d0-4d53-9f99-f1d780d10570",
    "8e20eb9a-1061-493c-9c21-add932521288",
    "0107e718-2c69-4411-8f35-544d76950b40",
    "dfa0450c-048f-4de3-8b21-bd581c65b4ab",
    "a92919dc-e617-4573-ba37-8040250d4405",
    "e00bdb0b-c1e3-4241-bbfa-99f1ecd9a01d",
    "5b31a826-8c3a-477d-bb0e-ac9aa4beb52a",
    "8ba76c4d-9d15-480f-9300-e156b89ecc28"
  )

  val prodIds: Array[String] = Array(
    "e2c1bb3e-4229-4688-9a2b-d2c2a5e08534",
    "e1d9c920-8204-4d9b-a762-f5419e4045bd",
    "5d1ca4ec-0364-4a21-895d-dd668e07a36c",
    "cc99224d-364e-4d4a-82fe-b6a9655e07ca",
    "38220392-4499-4df3-8638-e9e0e8cdfe81",
    "6b45d1c3-5c31-483f-9cfc-bab4640f042e",
    "5d1cbe20-4240-4a3f-b600-c8345b40be9a",
    "4ee8bccc-c2dc-4d81-af7e-17f7a216e3a9",
    "b566d437-8b08-49e5-8364-b47b5e671cc1",
    "39eaabd3-4c7d-4958-8821-19958e6ccb8b",
    "8388cf74-2e93-413e-9a04-452f12d562b9",
    "d58021e5-35b7-4b55-8e95-15b2c826844a",
    "98535388-fae4-458e-a4a2-a68ef2461dd7",
    "6b8b7d28-7933-4777-9884-3c5866ec0a92",
    "88fd2f7b-0214-467c-9170-e8f7314cb83d",
    "dd37a8e4-3234-4688-9e99-9247bc41fd03",
    "8809f7c6-33e8-40fc-b329-a924fd0b0fc2",
    "d0585bf3-39f4-4a77-8fe8-66d0a904bf70",
    "b7411a67-8cfc-41f1-b6b2-3bf303c91b7f",
    "c4445bff-5294-46cd-9f3c-bc648d80356a",
    "d37439c7-e37b-4c8a-bf5c-5dbf929fa4d7",
    "3971e750-0142-437c-ab12-b0ab20b08abe",
    "e06ebb81-b772-4ec0-a32b-b6ee752035d4",
    "7b9aaac4-5b89-4b97-86f4-3e8361e33d84",
    "89b171ee-f515-433c-85cc-a1ffa02dd27d",
    "058cc338-c3a6-4589-9a16-8b3676e09e0f",
    "a68e2fb8-8b8f-429c-8f87-4d1102247beb",
    "f13d393c-945a-45ff-a451-2bff9a8d2756",
    "dedb24a3-db9c-4727-84aa-eb4bba3433f6",
    "fde83552-e831-4919-886d-170e9d77b97a",
    "2ce2f0de-56d6-4974-8cf0-3c8532140a80",
    "c4792491-cae7-4044-b70e-9cd59b7bcadf",
    "5b23a9e7-dc05-4930-8114-94ea0b945736",
    "b1f39946-6fe9-4a2d-9c5a-300f9fdd4229",
    "8411b030-4d86-454b-8e4a-21af8e983b4b",
    "12e9dd05-5726-4f0c-b4b5-712f96ebf06d",
    "ba0a5f3c-3066-459d-805d-5762e9560f14",
    "a2343969-d21c-4646-82ba-69a1f141192b",
    "082740ec-200f-4bca-a3fe-c2d897127143",
    "f444fe33-c30e-43f8-bf8b-272cf4e7012c",
    "8c05f213-f480-43b9-b7c8-a26c60cc2624",
    "dba3b5c4-d9fb-4ae8-a1ce-dabff5d10e44",
    "fea625a3-ddad-4c44-9b8b-09787e55aa60",
    "79f39f55-2d71-4f1f-895e-6eaaa3b53af4",
    "8e73c1ff-ad5a-4b6d-a180-159341073420",
    "9271ce44-f711-48e6-8484-2971b4056e81",
    "93c0f780-86ce-423d-bb39-e23f53f2b63b",
    "28691310-bec7-4d36-a896-c62ce8cebef8",
    "b8571b8c-1053-4099-bf91-9c2a1c5b24ad",
    "e3d2c195-0a50-44f0-b219-34293afab10b"
  )
  
  val currentIds: Array[String] = localIds

  val users =
//    atOnceUsers(currentIds.length)
    constantUsersPerSec(400) during(1 minutes)
//    constantUsersPerSec(200) during(1 minutes)
//  		constantUsersPerSec(100) during(1 minutes)
//  		constantUsersPerSec(100) during(5 minutes)
//  		constantUsersPerSec(50) during(5 minutes)
//  		constantUsersPerSec(10) during(5 minutes)
//  		constantUsersPerSec(5) during(1 minutes)
//  		constantUsersPerSec(2) during(1 minutes)
//  		constantConcurrentUsers(10) during(5 minutes)
//  		constantConcurrentUsers(20) during(5 minutes)
//      constantConcurrentUsers(1) during(1 minutes)

  val feeder = currentIds.map( (imageId: String) => Map("imageId" -> imageId, "imagePath" -> imagePath(imageId)) ).circular


  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(baseUrl)
    //		.inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/74.0.3729.169 Chrome/74.0.3729.169 Safari/537.36")


  val headers_0 = Map(
    "accept" -> "image/webp,image/apng,image/*;q=0.8,application/signed-exchange;v=b3",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-AU,en-GB;q=0.9,en-US;q=0.8,en;q=0.7",
    "upgrade-insecure-requests" -> "1")

  val headers_29 = Map("Origin" -> s"$baseUrl")

  val headers_39 = Map("Upgrade-Insecure-Requests" -> "1")

  private val headers_40 = Map(
    "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-AU,en-GB;q=0.9,en-US;q=0.8,en;q=0.7",
    "cache-control" -> "max-age=0",
    "origin" -> s"$baseUrl",
    "upgrade-insecure-requests" -> "1")

  val uri1 = "https://www.google-analytics.com"
  val uri2 = "https://s3.amazonaws.com/assets.freshdesk.com/widget"
  val uri3 = "https://www.ala.org.au"
  val uri4 = "https://support.ala.org.au/loading.html"

  def imagePath(imageId: String): String = {
    val length = imageId.length
    s"${imageId.substring(length - 1)}/${imageId.substring(length - 2, length - 1) }/${imageId.substring(length - 3, length - 2)}/${imageId.substring(length - 4, length -3)}/$imageId"
  }


  def resources1(builder: HttpRequestBuilder): Unit = {
  }

  def resources2(): Unit = {
  }

  def resources3(): Unit = {
  }

  val apiScenario = scenario(s"Image Simulation $baseUrl API with $users")
    .feed(feeder)
    .exec(http("Request API original")
      .get("/image/${imageId}/original")
      .headers(headers_0)
    )
    .exec(http("Request API thumbnail")
      .get("/image/${imageId}/thumbnail")
      .headers(headers_0)
    )
    .exec(http("Request API thumbnail_large")
      .get("/image/${imageId}/large")
      .headers(headers_0)
    )
//    .exec(http("Request API thumbnail_square")
//      .get("/image/${imageId}/thumbnail_square")
//      .headers(headers_0)
//    )
//    .exec(http("Request API thumbnail_square_white")
//      .get("/image/${imageId}/thumbnail_square_white")
//      .headers(headers_0)
//    )
//    .exec(http("Request API tile")
//      .get("/image/${imageId}/tms/0/0/0.png")
//      .headers(headers_0)
//    )

  val storeScenario = scenario(s"Image Simulation $baseUrl /store images with $users")
    .feed(feeder)
    .exec(http("Request store original")
      .get("/store/${imagePath}/original")
      .headers(headers_0)
    )
    .exec(http("Request store thumbnail")
      .get("/store/${imagePath}/thumbnail")
      .headers(headers_0)
    )
    .exec(http("Request store thumbnail_large")
      .get("/store/${imagePath}/thumbnail_large")
      .headers(headers_0)
    )
    .exec(http("Request store thumbnail_square")
      .get("/store/${imagePath}/thumbnail_square")
      .headers(headers_0)
    )
    .exec(http("Request store thumbnail_square_white")
      .get("/store/${imagePath}/thumbnail_square_white")
      .headers(headers_0)
    )
    .exec(http("Request store tile")
      .get("/store/${imagePath}/tms/0/0/0.png")
      .headers(headers_0)
    )

}
