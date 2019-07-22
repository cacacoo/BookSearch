import React from "react";
import { withStyles } from '@material-ui/core/styles';
import {
    TableBody,
    TableRow,
    Typography
} from "@material-ui/core";
import Table from "@material-ui/core/Table";
import moment from 'moment'
import TableHead from "@material-ui/core/TableHead";
import TableCell from "@material-ui/core/TableCell";

const useStyles = () => ({
    root: {
        width: '100%',
    }
});

class SearchHistory extends React.Component {

    renderRows() {
        const {
            keywordHistoryResult = [],
        } = this.props;

        return keywordHistoryResult.map((history) => {
            const {
                id,
                searchKeyword,
                searchedAt
            } = history;

            return (
                <TableRow key={id}>
                    <TableCell align="left">{searchKeyword}</TableCell>
                    <TableCell align="left">{moment(searchedAt).format('YYYY년 MM월 DD일 HH시 mm분 ss초')}</TableCell>
                </TableRow>
            );
        });
    }

    render() {
        const { classes } = this.props;

        return (
            <div className={classes.root}>
                <Typography>사용자 검색이력</Typography>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell align="left">검색어</TableCell>
                            <TableCell align="left">조회일시</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {this.renderRows()}
                    </TableBody>
                </Table>
            </div>
        );
    }
}

export default withStyles(useStyles)(SearchHistory);




