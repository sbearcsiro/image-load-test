package ala

import io.gatling.core.Predef._

import ala._

class ImagesStoreSimulation extends Simulation {


	setUp(
		storeScenario.inject(
			users
		)
	).protocols(httpProtocol)

}