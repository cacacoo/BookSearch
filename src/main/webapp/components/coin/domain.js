export const findAllCoins = () => {
	return fetch("/coin/all").then((response) => {
		return response.json();
	})
};



