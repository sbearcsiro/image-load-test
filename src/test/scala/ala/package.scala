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

  val devIds: Array[String] = Array(
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

  val prodIds: Array[String] = Array(
    "c527ff8c-f756-4e51-ae26-02dd40c0194d",
    "2f35bf56-7ffb-42aa-9a5c-49537f8f1d8c",
    "f22c8ba4-ba9a-438e-a88b-6612b34309dc",
    "256f1933-b03c-42ce-a303-3cbc047e2875",
    "108b06a4-b28d-4785-9fbc-9a5d942f07ee",
    "6569d6b7-9974-4143-bc7c-bab358796551",
    "0d7a1884-2f0b-4ba9-9004-ef61801b8f4a",
    "d18a2991-0bc5-443f-836f-428fef04550b",
    "3e239e80-0adf-40e6-89aa-836bd98c9b1a",
    "666dd112-287a-4d3b-9504-ccb1144ebdc1",
    "81ada552-d1e6-4c07-94aa-592ab8478cdf",
    "b05165c8-993f-48f4-8147-d684d9f59853",
    "5f55cd54-83f0-4bed-81e9-c6304043c8ae",
    "e2097426-9d1b-42b6-b7ce-f096ff91f2b4",
    "fd67b9f1-53b2-437e-b8cd-5ab7534d4688",
    "d675db4d-28c4-4cef-9c16-9c67667ce451",
    "948a55f1-40b7-4f8b-b94b-d2357a8c8937",
    "f096108e-ae15-4ef8-9853-19d8c3508326",
    "2d889977-5f10-4253-afca-0fa2833f2e27",
    "b5133e84-6845-4ce0-b1f6-b86d725e5175",
    "36a44b3f-3077-4140-a25b-fde8245a32f6",
    "fcee19c7-430d-4772-b72a-f87e09776f6c",
    "c37cf8e5-f9a8-405f-a13c-fcaa8c193c9e",
    "ff0e4c21-c4ab-4d29-adb8-6b7a9eddbc4d",
    "16658763-010a-4b4b-8afd-c193f2985a32",
    "ca9e042d-8acd-4525-803e-e3ed228c8a80",
    "246826df-4cd1-4ee5-b2bf-1734012492b7",
    "9b36fa11-eaa5-4863-99c3-c10112800c06",
    "abf71e62-3019-4444-8de7-6a9285c5503b",
    "0f8200c6-b7aa-4903-b699-ebda946c15fc",
    "9b522c87-b3a6-40bf-8b7e-30176c5f75c0",
    "8cf8709e-90ea-42ce-b497-5b97f23cdaf6",
    "841787d1-0d44-4008-88fc-5292f55d57a3",
    "1adbb695-3c67-4f1f-8c4a-c356c2cbd708",
    "285ae8ab-ec27-43ca-b9e4-40f5290298df",
    "18f4b144-efe4-4ac4-9206-7efbac39e920",
    "07edabe3-9f48-4075-89ef-1a1f156597a1",
    "819e837a-8117-46d6-8bec-f5b2fd4faaa0",
    "aba902a4-e129-4bf6-9107-3877e9b7cf3b",
    "8449abfb-bcbf-430e-9ad4-443f9701e367",
    "25b94703-c31c-4f0f-8fe6-07a655686a21",
    "beaafb54-7dfc-4ba4-998a-0f20f174c0db",
    "853b17df-6fab-4371-8bec-e65870952998",
    "ef6ae330-ced8-4154-bc28-3fb3ed471b01",
    "1e1bfa37-5886-4b56-a977-a8c844d2b998",
    "fcaeaa4b-e90a-43e4-8292-0640d5a6e6d7",
    "e3da884f-d8c3-4b4e-b756-8969a1985629",
    "52e1e1ca-7a10-4e7b-a721-44a61c47539e",
    "20aa2db7-a9a4-4e6a-aee4-fb65756941ff",
    "51d69f39-605b-4a46-a985-65508c7e5508"
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
