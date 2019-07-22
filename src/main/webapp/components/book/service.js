import Action from './actions'
import {
	searchBook,
	searchUserKeywordHistory,
	searchHotKeywordTop10,
	putUserKeywordHistory,
	putUserKeywordCount
} from './domain'

const ActionCreator = {
	updateCondition(condition) {
		return {
			type: Action.UPDATE_CONDITION,
			value: condition
		};
	},
	updateBookResult(searchResult) {
		return {
			type: Action.UPDATE_BOOK_RESULT,
			value: searchResult
		}
	},
	updateKeywordHistoryResult(searchResult) {
		return {
			type: Action.UPDATE_KEYWORD_HISTORY_RESULT,
			value: searchResult
		}
	},
	updateHotKeywordResult(searchResult) {
		return {
			type: Action.UPDATE_HOT_KEYWORD_RESULT,
			value: searchResult
		}
	}
};

const Service = (dispatch) => ({
	async searchBook(condition) {
		dispatch(ActionCreator.updateCondition(condition));
		const result = await searchBook(condition);
		dispatch(ActionCreator.updateBookResult(result));
	},

	async putUserKeywordHistory(userId, keyword) {
		await putUserKeywordHistory(userId, keyword);
	},

	async searchUserKeywordHistory(userId) {
		const result = await searchUserKeywordHistory(userId);
		dispatch(ActionCreator.updateKeywordHistoryResult(result));
	},

	async putKeywordCount(keyword) {
		await putUserKeywordCount(keyword);
	},

	async searchHotKeywordTop10() {
		const result = await searchHotKeywordTop10();
		dispatch(ActionCreator.updateHotKeywordResult(result));
	},
});

export default Service;