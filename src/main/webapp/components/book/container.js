import React from "react";
import { connect } from "react-redux"
import Service from "./service";

import {Table, TableBody, TableCell, TableHead, TableRow } from '@material-ui/core';

class BookContainer extends React.Component {

	renderRows() {
		const {
			searchResult = {}
		} = this.props;

		const {
			documents = []
		} = searchResult;

		return Object.keys(documents).map((book) => {
			return (
				<BookRow
					book={book}
				/> );
		});
	}

	render() {
		return (
			<div>
				<h1>book list</h1>
				<Table>
					<TableHead>
						<TableRow>
							<TableCell >title</TableCell>
							<TableCell >isbn</TableCell>
							<TableCell >publisher</TableCell>
							<TableCell >price</TableCell>
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

class BookRow extends React.Component {


	render() {
		const {
			book : {
				title,
				isbn,
				publisher,
				price
			},
		} = this.props;

		return (
			<TableRow key={isbn}>
				<TableCell>{title}</TableCell>
				<TableCell>{isbn}</TableCell>
				<TableCell>{publisher}</TableCell>
				<TableCell>{price}</TableCell>
			</TableRow>
		);
	}
}

export default connect(state => state, Service)(BookContainer);

