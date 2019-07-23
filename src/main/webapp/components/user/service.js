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
});

export default Service;