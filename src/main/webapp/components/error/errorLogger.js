import React from 'react';

class ErrorLogger extends React.Component {

	getInitialState() {
		return {
			error: null,
			errorInfo: null
		}
	}

	componentDidCatch(error, errorInfo) {
		this.setState({
			error: error,
			errorInfo: errorInfo
		});
	}

	reportError(...errors) {
		if(!errors) {
			return;
		}
		console.log(errors);
		errors.forEach(error => {
			console.error(error);
		});
	}

	render() {
		const { error, errorInfo } = this.state;
		if(error) {
			this.reportError(error, errorInfo);
			throw error;
		}

		return this.props.children;
	};

}

export default ErrorLogger;