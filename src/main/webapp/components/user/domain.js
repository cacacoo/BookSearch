import 'babel-polyfill';

export const logIn = async (userId, pwd) => {
	if(!userId || !pwd) return {
		success: false,
		message: "필수값이 비었습니다."
	};

	try {
		const response = await fetch('/log/in?userId='+ userId + '&pwd='+ pwd);
		return await response.json();
	} catch (err) {
		console.error(err);
	}
};

export const signUp = async (userId, pwd) => {
	if(!userId || !pwd) return {
		success: false,
		message: "필수값이 비었습니다."
	};

	try {
		const response = await fetch(
			'/sign/up?userId='+ userId + '&pwd='+ pwd,
			{method: 'PUT'});
		return await response.json();
	} catch (err) {
		console.error(err);
	}
};










