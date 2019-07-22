import Action from './actions'
import {
	logIn,
	logOut,
	signUp
} from './domain'

const ActionCreator = {
	logIn(response) {
		return {
			type: Action.LOGIN,
			value: response
		}
	},
	signUp(response) {
		return {
			type: Action.SIGNUP,
			value: response
		}
	},
	logOut() {
		return {
			type: Action.LOGOUT
		}
	}
};

const Service = (dispatch) => ({
	async signUp(userId, pwd) {
		const response = await signUp(userId, pwd);
		dispatch(ActionCreator.signUp(response));
	},

	async logIn(userId, pwd) {
		const response = await logIn(userId, pwd);
		dispatch(ActionCreator.logIn(response));
	},

	async logOut(userId) {
		const response = await logOut(userId);
		if(response) {
			dispatch(ActionCreator.logOut());
		}
	},

});

export default Service;