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
		case Actions.SEARCH:
			return Object.assign({}, state, { condition: action.condition });
		case Actions.UPDATE_SEARCH_RESULT:
			return Object.assign({}, state, { searchResult: action.searchResult });

		default:
			return state;
	}
};

export default Reducer;