import 'babel-polyfill';

export const search = async (condition) => {
	try {
		const response = await fetch('/book/search', {
			method: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(condition)
		});

		return await response.json();
	} catch (err) {
		console.error(err);
	}
};









