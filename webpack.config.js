module.exports = {
	entry: ['./src/index.js'],
	output: {
		path : __dirname + '/src/main/resources/static/',
		filename : "bundle.js"
	},

	devServer: {
		inline: true,
		port: 7777,
		contentBase: __dirname + '/src/main/resources/static/'
	},

	module: {
		rules: [
			{
				test: /\.js$/,
				exclude: /node_modules/,
				use: {
					loader: "babel-loader",
					options: {
						presets: ['@babel/preset-env','@babel/preset-react']
					}
				}
			}
		]
	}
};