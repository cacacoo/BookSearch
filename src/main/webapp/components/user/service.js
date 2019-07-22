import Action from './actions'
import {
	logIn,
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

	async logOut() {
		dispatch(ActionCreator.logOut());
	},

});

export default Service;