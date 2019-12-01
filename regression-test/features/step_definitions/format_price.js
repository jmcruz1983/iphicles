'use strict'

require('should')
const inspector = require('schema-inspector')
const {defineSupportCode} = require('cucumber')
const priceSchema = require('../support/schema/price_validation')

defineSupportCode(function({When, Then}) {

  let stringList

  When(/^Fetched list of naughty strings$/, function () {
    stringList = require('../support/data/blns.json')
  })

  Then(/^All prices should be NaN$/, function () {
    return Array.from(stringList).forEach(item => {
      this.clients.apiClient.formatPrice(item)
        .then(response => {
          inspector.validate(priceSchema.response('NaN'), response)
            .valid.should.be.true()
        })
    })
  })
})
