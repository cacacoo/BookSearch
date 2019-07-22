import React from "react";
import {
    ExpansionPanel, ExpansionPanelDetails,
    ExpansionPanelSummary,
    Table,
    TableBody,
    TableFooter,
    TablePagination,
    TableRow, Typography
} from "@material-ui/core";
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import BookDetail from "./detail"

class BookTable extends React.Component {

    renderRows() {
        const {
            bookResult = {}
        } = this.props;

        const {
            documents = []
        } = bookResult;

        return documents.map((book) => {
            const {
                isbn,
                title
            } = book;

            return (
                <TableRow key={isbn}>
                    <ExpansionPanel>
                        <ExpansionPanelSummary expandIcon={<ExpandMoreIcon/>}>
                            <Typography>{title}</Typography>
                        </ExpansionPanelSummary>
                        <ExpansionPanelDetails>
                            <BookDetail book={book}/>
                        </ExpansionPanelDetails>
                    </ExpansionPanel>
                </TableRow>
            );
        });
    }

    render() {
        const {
            condition = {},
            bookResult = {},
            handleChangeRowsPerPage,
            handleChangePage
        } = this.props;

        const {
            meta = {},
        } = bookResult;

        const {
            pageableCount = 10,
        } = meta;

        const {
            page,
            size
        } = condition;

        return (
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
                            onChangePage={(event, page) => handleChangePage(event, page)}
                            onChangeRowsPerPage={(event) => handleChangeRowsPerPage(event)}
                        />
                    </TableRow>
                </TableFooter>
            </Table>
        )
    }
}

export default BookTable;