import 'babel-polyfill';

export const searchBook = async (condition) => {
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

export const searchUserKeywordHistory = async (userId) => {
	if(!userId) return [];
	try {
		const response = await fetch('/user/search?userId='+ userId );
		return await response.json();
	} catch (err) {
		console.error(err);
	}
};

export const searchHotKeywordTop10 = async () => {
	try {
		const response = await fetch('/keyword/count');
		return await response.json();
	} catch (err) {
		console.error(err);
	}
};

export const putUserKeywordHistory = async (userId, keyword) => {
	if(!userId || !keyword) return false;

	try {
		const response = await fetch(
			'/user/search?userId='+ userId + '&keyword='+ keyword,
			{method: 'PUT'});
		return await response.json();
	} catch (err) {
		console.error(err);
	}
};

export const putUserKeywordCount = async (keyword) => {
	if(!keyword) return false;

	try {
		const response = await fetch(
			'/keyword/count?keyword='+ keyword,
			{method: 'PUT'});
		return await response.json();
	} catch (err) {
		console.error(err);
	}
};









