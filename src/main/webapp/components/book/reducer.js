import Actions from "./actions";

const defaultState = {
	condition: {
		query:'',
		page: 1,
		size: 10,
	}
};

const Reducer = (state = defaultState, action) => {
	switch (action.type) {
		case Actions.UPDATE_CONDITION:
			return Object.assign({}, state, { condition: action.value });
		case Actions.UPDATE_SEARCH_RESULT:
			console.log(action.value)
			return Object.assign({}, state, { searchResult: action.value });

		default:
			return state;
	}
};

export default Reducer;