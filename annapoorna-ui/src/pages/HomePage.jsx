import TopRestaurant from '../components/TopRestaurant.jsx';
import ViewAllJobs from "../components/ViewAllJobs.jsx";
import WhatsOnYourMind from "../components/WhatsOnYourMind.jsx";
import AllRestaurants from "../components/AllRestaurants.jsx";
const HomePage = () => {
    return(
        <>
            <WhatsOnYourMind/>
            <TopRestaurant/>
            <AllRestaurants />
            <ViewAllJobs/>
        </>
    )
 }

 export default HomePage;