module.exports = function (config) {
  config.set({
    basePath: '',
    // Solo Jasmine (sin Vite)
    frameworks: ['jasmine'],

    // Plugins mínimos para ejecutar en Chrome
    plugins: ['karma-jasmine', 'karma-chrome-launcher', 'karma-spec-reporter'],

    // Cargar primero la lógica y luego las specs
    files: [
      { pattern: 'src/utils/**/*.logic.js', watched: true, included: true },
      { pattern: 'src/**/*.logic.spec.js', watched: true, included: true }
    ],

    reporters: ['spec'],
    specReporter: {
      suppressErrorSummary: false,
      suppressFailed: false,
      suppressPassed: false,
      suppressSkipped: true,
      showSpecTiming: true
    },

    // Navegador por defecto (puedes sobreescribir con KARMA_BROWSERS)
    browsers: (process.env.KARMA_BROWSERS ? process.env.KARMA_BROWSERS.split(',') : ['ChromeHeadless']),

    // Modo CI por defecto (una sola corrida)
    singleRun: true,
    autoWatch: false,

    // Limitar concurrencia para instancias pequeñas
    concurrency: 1,

    client: {
      clearContext: false,
      jasmine: {
        random: false
      }
    },

    browserNoActivityTimeout: 60000,
    browserDisconnectTimeout: 20000,
    browserDisconnectTolerance: 1
  });
};
