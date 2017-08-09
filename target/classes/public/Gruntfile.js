module.exports = function(grunt) {

  grunt.initConfig({
    jshint: {      
      files: ['Gruntfile.js','../static/*.html','bower_components/*','bower.json','package.json'],
      options: {
        globals: {
          jQuery: true
        }
      }
    },
    watch: {
      files: ['<%= jshint.files %>'],
      tasks: ['jshint','wiredep'],
      options: {
                livereload: true,
              }
    },
    wiredep:{
    	 task: {    		   
    		 	expand:true,
    		    src: ['../static/*.html'],
    		    ignorePath: '../public',
    		    dependencies:true
    		  },    		  
    	}
  });

  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-wiredep');

  grunt.registerTask('default', ['wiredep']);

};