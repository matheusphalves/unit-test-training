const sum = (numberA, numberB) => {
    return numberA + numberB;
}

const inOneHour = () => {
    const now = Date.now()
    const oneHourInMili = 1*60*60*1000
    return now + oneHourInMili;
}

module.exports = { sum, inOneHour }