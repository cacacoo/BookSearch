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
		case Actions.UPDATE_BOOK_RESULT:
			return Object.assign({}, state, { bookResult: action.value });
		case Actions.UPDATE_KEYWORD_HISTORY_RESULT:
			return Object.assign({}, state, { keywordHistoryResult: action.value });
		case Actions.UPDATE_HOT_KEYWORD_RESULT:
			return Object.assign({}, state, { hotKeywordResult: action.value });

		default:
			return state;
	}
};

export default Reducer;