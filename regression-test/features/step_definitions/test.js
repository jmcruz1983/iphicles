'use strict'

const {defineSupportCode} = require('cucumber')

defineSupportCode(function({Given, When, Then}) {

  Given(/^bla1$/, function () {
    console.log('bla1')
  })

  When(/^bla2$/, function () {
    console.log('bla2')
  })

  Then(/^bla3$/, function () {
    console.log('bla3')
  })
})
