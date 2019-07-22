import React from "react";
import {connect} from "react-redux"
import Service from "./service";
import BookAppBar from "./ui/appbar"
import BookDetail from "./ui/detail"
import {
    ExpansionPanel,
    ExpansionPanelDetails,
    ExpansionPanelSummary,
    Table,
    TableBody,
    TableFooter,
    TablePagination,
    TableRow,
    Typography
} from '@material-ui/core';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';

class BookContainer extends React.Component {

    renderRows() {
        const {
            searchResult = {}
        } = this.props;

        const {
            documents = []
        } = searchResult;

        return documents.map((book) => {
            return (
                <BookRow
                    key={book.isbn}
                    book={book}
                />);
        });
    }

    searchKeyword(keyword) {
        this.props.search({
            query: keyword,
            page: 1,
            size: 10
        });
    }

    handleChangePage(event, newPage) {
        const {
            condition = {},
            search
        } = this.props;

        search({
            query: condition.query,
            page: newPage + 1,
            size: condition.size
        });
    }

    handleChangeRowsPerPage(event) {
        const {
            condition = {},
            search
        } = this.props;

        search({
            query: condition.query,
            page: 1,
            size: +event.target.value
        });
    }

    render() {
        const {
            condition = {},
            searchResult = {}
        } = this.props;

        const {
            meta = {},
        } = searchResult;

        const {
            pageableCount = 10,
        } = meta;

        const {
            page,
            size
        } = condition;

        return (
            <div>
                <BookAppBar
                    searchKeyword={(keyword) => this.searchKeyword(keyword)}
                />
                <Table>
                    <TableBody>
                        {this.renderRows()}
                    </TableBody>
                    <TableFooter>
                        <TableRow>
                            <TablePagination
                                rowsPerPageOptions={[5, 10, 25]}
                                count={pageableCount}
                                rowsPerPage={size}
                                page={page - 1}
                                SelectProps={{
                                    inputProps: {'aria-label': 'Rows per page'},
                                    native: true,
                                }}
                                onChangePage={(event, page) => this.handleChangePage(event, page)}
                                onChangeRowsPerPage={(event) => this.handleChangeRowsPerPage(event)}
                            />
                        </TableRow>
                    </TableFooter>
                </Table>
            </div>
        )
    }
}

class BookRow extends React.Component {

    render() {
        const {
            book = {}
        } = this.props;

        const {
            title = '',
            isbn = '',
        } = book;

        return (
            <ExpansionPanel key={isbn}>
                <ExpansionPanelSummary
                    expandIcon={<ExpandMoreIcon/>}
                    aria-controls="panel1c-content"
                    id="panel1c-header">
                    <Typography>{title}</Typography>
                </ExpansionPanelSummary>
                <ExpansionPanelDetails>
                    <BookDetail book={book}/>
                </ExpansionPanelDetails>
            </ExpansionPanel>
        );
    }
}

export default connect(state => state, Service)(BookContainer);

