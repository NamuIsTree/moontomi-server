package com.moontomi.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MoontomiServerApplication

fun main(args: Array<String>) {
	runApplication<MoontomiServerApplication>(*args)
}
