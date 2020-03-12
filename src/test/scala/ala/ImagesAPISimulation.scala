package ala

import io.gatling.core.Predef._

import ala._

class ImagesAPISimulation extends Simulation {

	setUp(
		apiScenario.inject(
			users
		)
	).protocols(httpProtocol)

}