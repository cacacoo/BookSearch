import React from "react";
import { connect } from "react-redux"
import Button from "material-ui/Button";
import { findAllCoins } from './domain';
import Service from "./service";

import Table, { TableBody, TableCell, TableHead, TableRow } from 'material-ui/Table';

class Coin extends React.Component {

	constructor(props) {
		super(props);
		findAllCoins().then((data) => {
			this.props.loadData(data);
		});
	}

	renderRows() {
		const {
			coins = {},
			changeValue
		} = this.props;

		return Object.keys(coins).map((coinId) => {
			const coin = coins[coinId];
			return (
				<CoinRow
					coin={coin}
					changeValue={changeValue}
				/> );
		});
	}

	render() {
		return (
			<div>
				<h1>coin controller</h1>
				<Table>
					<TableHead>
						<TableRow>
							<TableCell numeric>Id</TableCell>
							<TableCell numeric>Name</TableCell>
							<TableCell numeric>Value</TableCell>
							<TableCell numeric>Setting</TableCell>
						</TableRow>
					</TableHead>
					<TableBody>
						{this.renderRows()}
					</TableBody>
				</Table>
			</div>
		)
	}
}

class CoinRow extends React.Component {

	changeValue(coinId, value) {
		this.props.changeValue(coinId, value);
	}

	render() {
		const {
			coin : {
				coinId,
				coinName,
				coinValue
			},
		} = this.props;

		return (
			<TableRow key={coinId}>
				<TableCell numeric>{coinId}</TableCell>
				<TableCell >{coinName}</TableCell>
				<TableCell numeric>{coinValue}</TableCell>
				<TableCell numeric>
					<Button
						variant="raised"
						color="primary"
						style={{margin: '5px'}}
						onClick={() => this.changeValue(coinId, coinValue + 1)}>
						+
					</Button>
					<Button
						variant="raised"
						color="secondary"
						style={{margin: '5px'}}
						onClick={() => this.changeValue(coinId, coinValue - 1)}>
						-
					</Button>
				</TableCell>
			</TableRow>
		);
	}
}

export default connect(state => state, Service)(Coin);

