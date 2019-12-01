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
  }).catch((err) => {
    throw Error(`${this.apiUrl}/formatPrice ${err}`)
  })
}

exports.create = (config) => {
  return new APIClient(config)
}
