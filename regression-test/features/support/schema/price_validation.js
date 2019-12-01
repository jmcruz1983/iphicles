'use strict'

exports.response = (price) => {
  return {
    type: 'object',
    properties: {
      price: { type: 'string', eq: price }
    }
  }
}
