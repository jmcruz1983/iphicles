'use strict'

const {defineSupportCode} = require('cucumber')
const trim = require('lodash').trim

const APPLICATION_VERSION = trim(process.env.APPLICATION_VERSION) || 'local'

let config = {}
let clients = {}

defineSupportCode(function({BeforeAll}) {
  BeforeAll(function () {
    config = {}
    if (process.env.MODE === 'CLUSTERED') {
      config.BACK_END_API = 'http://back-end:8080/api'
    } else {
      config.BACK_END_API = 'http://localhost:5000/api'
    }

    clients.apiClient = require('./api_client').create(config)

    console.info('Regression test environment')
    console.info(`Version: ${APPLICATION_VERSION}`)
    console.info(`Configuration: ${JSON.stringify(config)}`)
  })
})
