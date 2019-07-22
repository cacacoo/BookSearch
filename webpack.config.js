module.exports = {
	entry: ['./src/index.js'],
	output: {
		path : __dirname + '/src/main/resources/static/',
		filename : "bundle.js"
	},

	devServer: {
		inline: true,
		contentBase: __dirname + '/src/main/resources/static/',
		compress: true,
		publicPath: '/',
		host: "0.0.0.0",
		port: 7777,
		proxy: {
			"**": "http://localhost:8080"
		},
		historyApiFallback: true
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