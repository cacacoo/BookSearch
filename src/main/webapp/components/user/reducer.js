import Actions from "./actions";

const Reducer = (state = {}, action) => {
	switch (action.type) {
		case Actions.SIGNUP:
			const { message } = action.value;
			return Object.assign({}, state, {
				failMessage: message
			});
		case Actions.LOGIN:
			return Object.assign({}, state, {
				userInfo: action.value.user,
				failMessage: action.value.message
			});
		case Actions.LOGOUT:
			return Object.assign({}, state,{});

		default:
			return state;
	}
};

export default Reducer;