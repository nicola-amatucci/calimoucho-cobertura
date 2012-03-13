# IMPORTANT!

A better version is at

	https://github.com/nicola-amatucci/calimoucho-cobertura-opensas

# Calimoucho-Cobertura

Calimoucho is a Play continuous integration server

	https://github.com/guillaumebort/calimoucho

Cobertura is a module for the Play! framework provides a plugin to support the Cobertura test coverage tool.

	http://www.playframework.org/documentation/1.0.1/cobertura

Calimucho-Cobertura integrates Cobertura module reports in Calimoucho web interface

Built on Play Framework 1.2.4, Cobertura Module 2.1

# Usage

Modify conf/projects.yml according to your setting. Start with

	play run

and open in your browser

	http://localhost:8084/

Note that 8084 is default port, you can change it in application.conf

# Calimoucho-Cobertura application.conf new options

	job.run-if-no-results=true

This option can be "true" or "false". When index action is requested, if this option is set to "true" and there is no test result, test execution job is started.

	mail.enabled=false

This option can be "true" or "false". Enables mail notices.

# Notes about Configuring Cobertura

First read the documentation

	http://www.playframework.org/documentation/1.0.1/cobertura

you need this in application.conf (not in calimucho-cobertura, but in the folder of the application under test)

	%test.module.cobertura=modules/cobertura-2.1
	%test.play.tmp=none 

this line has to be removed

	%test.cobertura.silent=false

so cobertura will run automatically on play auto-test




