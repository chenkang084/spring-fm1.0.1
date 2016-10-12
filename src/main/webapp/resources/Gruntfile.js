module.exports = function(grunt){

    console.log(111)

	grunt.initConfig({
		pkg:grunt.file.readJSON('package.json'),

		uglify: {
            options: {
                stripBanners: true,
                banner: '/*! <%= pkg.name %> - v<%= pkg.version %> - ' +
                    '<%= grunt.template.today("yyyy-mm-dd") %> */'
            },
            build: {
                src: 'src/*.js',
                dest: 'build/<%=pkg.name%>-<%=pkg.version%>.js.min.js'
            }
        }
	});

	grunt.loadNpmTasks('grunt-contrib-uglify');

	grunt.registerTask('default',['uglify'])
}