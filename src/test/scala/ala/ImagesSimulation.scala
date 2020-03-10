package ala

import java.net.URLEncoder

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

class ImagesSimulation extends Simulation {

//	private val baseUrl = "https://images.ala.org.au"
	private val baseUrl = "https://images-dev.ala.org.au"
//	private val baseUrl = "https://devt.ala.org.au/images"


//	val feeder = Array(
//		Map("username" -> username, "password" -> password, "rememberMe" -> false)
//		,Map("username" -> username2, "password" -> password2, "rememberMe" -> false)
//		,Map("username" -> username, "password" -> password, "rememberMe" -> true)
//		,Map("username" -> username2, "password" -> password2, "rememberMe" -> true)
//	).circular

	private val httpProtocol = http
		.baseUrl(baseUrl)
		//		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/74.0.3729.169 Chrome/74.0.3729.169 Safari/537.36")

	private val headers_0 = Map(
	"accept" -> "image/webp,image/apng,image/*;q=0.8,application/signed-exchange;v=b3",
	"accept-encoding" -> "gzip, deflate, br",
	"accept-language" -> "en-AU,en-GB;q=0.9,en-US;q=0.8,en;q=0.7",
	"upgrade-insecure-requests" -> "1")

	private val headers_29 = Map("Origin" -> baseUrl)

	private val headers_39 = Map("Upgrade-Insecure-Requests" -> "1")

	private val headers_40 = Map(
	"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
	"accept-encoding" -> "gzip, deflate, br",
	"accept-language" -> "en-AU,en-GB;q=0.9,en-US;q=0.8,en;q=0.7",
	"cache-control" -> "max-age=0",
	"origin" -> baseUrl,
	"upgrade-insecure-requests" -> "1")

	val uri1 = "https://www.google-analytics.com"
	val uri2 = "https://s3.amazonaws.com/assets.freshdesk.com/widget"
	val uri3 = "https://www.ala.org.au"
	val uri4 = "https://support.ala.org.au/loading.html"

	val users =
//		atOnceUsers(1)
		constantUsersPerSec(20) during(2 minutes)
//		constantUsersPerSec(10) during(5 minutes)
//		constantUsersPerSec(5) during(1 minutes)
//		constantUsersPerSec(2) during(1 minutes)
//		constantConcurrentUsers(10) during(5 minutes)
//		constantConcurrentUsers(20) during(5 minutes)
//			constantConcurrentUsers(1) during(1 minutes)

//	val imageId = "2e218384-4998-4412-8dba-cee548987afa"

	val devIds = Array(
		"e2c1bb3e-4229-4688-9a2b-d2c2a5e08534",
		"38220392-4499-4df3-8638-e9e0e8cdfe81",
		"dd37a8e4-3234-4688-9e99-9247bc41fd03"
	)

	val feeder = devIds.map( (imageId: String) => Map("imageId" -> imageId, "imagePath" -> imagePath(imageId)) ).random


//	val feeder = Array(
//		Map("imageId" -> "2e218384-4998-4412-8dba-cee548987afa"),
//		Map("imageId" -> "38220392-4499-4df3-8638-e9e0e8cdfe81"),
//		Map("imageId" -> "dd37a8e4-3234-4688-9e99-9247bc41fd03")
//	).random

//	val imagePathVal = imagePath(imageId)

	val scn = scenario(s"ImagesSimulation $baseUrl with $users")
  	.feed(feeder)
		.exec(http("Request store ${imageId} original")
			.get("/store/${imagePath}/original")
			.headers(headers_0)
			//			.check(
			//			)
		)
		.exec(http("Request store ${imageId} thumbnail")
			.get("/store/${imagePath}/thumbnail")
			.headers(headers_0)
//			.check(
//			)
		)
//		.exitHereIfFailed
//		.pause(2,5)
		.exec(http("Request store ${imageId} thumbnail_large")
			.get("/store/${imagePath}/thumbnail_large")
			.headers(headers_0)
//			.check(
//			)
		)
//		.exitHereIfFailed
//		.pause(1,5)
		.exec(http("Request store ${imageId} thumbnail_square")
			.get("/store/${imagePath}/thumbnail_square")
			.headers(headers_0)
//			.check(
//			)
		)
		.exec(http("Request store ${imageId} thumbnail_square_white")
			.get("/store/${imagePath}/thumbnail_square_white")
			.headers(headers_0)
//			.check(
//			)
		)
		.exec(http("Request store ${imageId} tile")
			.get("/store/${imagePath}/tms/0/0/0.png")
			.headers(headers_0)
//			.check(
//			)
		)
		.exec(http("Request API ${imageId} original")
			.get("/image/${imageId}/original")
			.headers(headers_0)
			//			.check(
			//			)
		)
		.exec(http("Request API ${imageId} thumbnail")
			.get("/image/${imageId}/thumbnail")
			.headers(headers_0)
//			.check(
//			)
		)
		//		.exitHereIfFailed
		//		.pause(2,5)
		.exec(http("Request API ${imageId} thumbnail_large")
			.get("/image/${imageId}/large")
			.headers(headers_0)
//			.check(
//			)
		)
		//		.exitHereIfFailed
		//		.pause(1,5)
//		.exec(http("Request API thumbnail_square")
//			.get("/image/${imageId}/thumbnail_square")
//			.headers(headers_0)
//		)
//		.exec(http("Request API thumbnail_square_white")
//			.get("/image/${imageId}/thumbnail_square_white")
//			.headers(headers_0)
//		)
//		.exec(http("Request API tile")
//			.get(s"/image/$imageId/tms/0/0/0.png")
//			.headers(headers_0)
////			.check(
////			)
//		)

	setUp(
		scn.inject(
			users
		)
	).protocols(httpProtocol)

	def resources1(builder: HttpRequestBuilder): Unit = {
	}

	def resources2(): Unit = {
	}

	def resources3(): Unit = {
	}

	def imagePath(imageId: String): String = {
		val length = imageId.length
		s"${imageId.substring(length - 1)}/${imageId.substring(length - 2, length - 1) }/${imageId.substring(length - 3, length - 2)}/${imageId.substring(length - 4, length -3)}/$imageId"
	}

}