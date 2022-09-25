// import {Link} from 'react-router-dom'
// import { baseUrl } from '../../Shared/baseUrl'
import BeerLover from '../BeerLover/BeerLover'
import Brewer from '../Brewer/BrewerPage'
import { useState, useEffect } from 'react'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'

const mapStateToProps = state => {
    return {
        user: state.user,
        profile: state.profile
    }
}

function Home(props) {

    const [profileView, setType] = useState('');

    useEffect(() => {
        setType(props.profile.profileType)
    },[props.profile.profileType]);

    return(
        <div>
            { profileView === "Brewer" ?
            <Brewer /> : <BeerLover/> }
        </div>
    )
}

export default withRouter(connect(mapStateToProps)(Home));