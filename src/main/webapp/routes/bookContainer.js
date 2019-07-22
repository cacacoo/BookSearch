import React from "react";
import {connect} from "react-redux"
import Service from "../components/book/service";
import BookAppBar from "../components/book/ui/appbar"
import BookTable from "../components/book/ui/bookTable"
import {withStyles} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import CssBaseline from "@material-ui/core/CssBaseline";
import Container from "@material-ui/core/Container";
import HotKeywordList from '../components/book/ui/hotKeywordList';
import SearchHistory from '../components/book/ui/searchHistory';

const useStyles = (theme) => ({
    root: {
        display: 'flex',
    },
    toolbar: {
        paddingRight: 24,
    },
    menuButton: {
        marginRight: 36,
    },
    menuButtonHidden: {
        display: 'none',
    },
    title: {
        flexGrow: 1,
    },
    appBarSpacer: theme.mixins.toolbar,
    content: {
        flexGrow: 1,
        height: '100vh',
        overflow: 'auto',
    },
    container: {
        paddingTop: theme.spacing(4),
        paddingBottom: theme.spacing(4),
    },
    paper: {
        padding: theme.spacing(2),
        display: 'flex',
        overflow: 'auto',
        flexDirection: 'column',
    },
    fixedHeight: {
        height: '100%',
    },
});


class BookContainer extends React.Component {

    componentDidMount() {
        const {
            user = {},
            searchUserKeywordHistory,
            searchHotKeywordTop10
        } = this.props;
        const { userInfo = {} }= user;
        const { userId = ''} = userInfo;

        searchUserKeywordHistory(userId);
        searchHotKeywordTop10();
    }

    searchKeyword(keyword) {
        const {
            user = {},
            searchBook,
            putUserKeywordHistory,
            putKeywordCount,
            searchUserKeywordHistory,
            searchHotKeywordTop10
        } = this.props;

        const { userInfo = {} }= user;
        const { userId = ''} = userInfo;

        Promise.all([
            searchBook({
                query: keyword,
                page: 1,
                size: 10,
            }),
            putUserKeywordHistory(userId, keyword),
            putKeywordCount(keyword)]
        ).then(() => {
            searchUserKeywordHistory(userId);
            searchHotKeywordTop10();
        });
    }

    handleChangePage(event, newPage) {
        const {
            book : { condition = {} },
            searchBook
        } = this.props;

        searchBook({
            query: condition.query,
            page: newPage + 1,
            size: condition.size
        });
    }

    handleChangeRowsPerPage(event) {
        const {
            book : {
                condition = {},
                searchBook
            }
        } = this.props;

        searchBook({
            query: condition.query,
            page: 1,
            size: +event.target.value
        });
    }

    render() {
        const {
            book : {
                condition,
                bookResult,
                keywordHistoryResult,
                hotKeywordResult,
            },
            classes
        } = this.props;

        return (
            <div className={classes.root}>
                <CssBaseline />
                <BookAppBar
                    searchKeyword={(keyword) => this.searchKeyword(keyword)}/>

                <main className={classes.content}>
                    <div className={classes.appBarSpacer} />
                    <Container maxWidth="lg" className={classes.container}>
                        <Grid container spacing={3}>
                            <Grid item xs={12} md={8} lg={9}>
                                <Paper className={classes.fixedHeight}>
                                    <BookTable
                                        condition={condition}
                                        bookResult={bookResult}
                                        handleChangePage={(event, page) => this.handleChangePage(event, page)}
                                        handleChangeRowsPerPage={(event) => this.handleChangeRowsPerPage(event)}
                                    />
                                </Paper>
                            </Grid>
                            <Grid item xs={12} md={4} lg={3}>
                                <Paper className={classes.paper}>
                                    <HotKeywordList hotKeywordResult={hotKeywordResult}/>
                                </Paper>
                            </Grid>
                            <Grid item xs={12}>
                                <Paper className={classes.paper}>
                                    <SearchHistory keywordHistoryResult={keywordHistoryResult}/>
                                </Paper>
                            </Grid>
                        </Grid>
                    </Container>
                </main>
            </div>
        )
    }
}

export default connect(state => state, Service)(withStyles(useStyles)(BookContainer));

