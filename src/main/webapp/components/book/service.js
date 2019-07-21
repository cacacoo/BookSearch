import Action from './actions'
import { search } from './domain'

const ActionCreator = {
	search(condition) {
		return {
			type: Action.SEARCH,
			value: condition
		};
	},
	updateSearchResult(searchResult) {
		return {
			type: Action.UPDATE_SEARCH_RESULT,
			value: searchResult
		}
	}
};

const Service = (dispatch) => ({
	search(condition) {
		dispatch(ActionCreator.search(condition));
		const result = search(condition);
		dispatch(ActionCreator.updateSearchResult(result));
	},
});

export default Service;