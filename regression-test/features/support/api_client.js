'use strict'

const rp = require('request-promise')

function APIClient(config) {
  this.apiUrl = config.BACK_END_API
  APIClient.prototype.apiUrl = config.BACK_END_API
}

APIClient.prototype.formatPrice = function (price) {
  return rp({
    method: 'POST',
    uri: `${this.apiUrl}/formatPrice`,
    json: true,
    body: price
  })
}

exports.create = (config) => {
  return new APIClient(config)
}
