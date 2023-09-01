const { sum, inOneHour } = require('./code')

describe('math functions', () => {

    beforeAll(() => {
        console.log('before all')
    })

    beforeEach(() => {
        console.log('before each')
    })

    it('sum of 2 numbers', () => {
        expect(sum(1, 2)).toBe(3)
    })
})

describe('date functions', () => {

    let realDate = null; 

    beforeAll(() => {
        realDate = Date.now.bind(global.Date)
        global.Date.now = () => 0;
    })


    afterAll(() => {
        global.Date.now = realDate;
    })

    it('returns the timestamp for a hour', () => {
        expect(inOneHour()).toBe(3600000)
        console.log(Date.now())
    })
})
